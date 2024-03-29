package com.example.wilspayoneer.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.wilspayoneer.R;
import com.example.wilspayoneer.core.BaseException;
import com.example.wilspayoneer.core.ExpressoIdlingResource;
import com.example.wilspayoneer.core.HttpCallback;
import com.example.wilspayoneer.core.NetworkUtil;
import com.example.wilspayoneer.core.Utils;
import com.example.wilspayoneer.data.model.ApplicableItem;
import com.example.wilspayoneer.databinding.ActivityMainBinding;
import com.example.wilspayoneer.domain.RepositoryImpl;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainActivity extends AppCompatActivity implements HttpCallback<List<ApplicableItem>> {

    private ActivityMainBinding binding;
    private List<ApplicableItem> applicableItemList = new ArrayList<>();
    private final RepositoryImpl repository = new RepositoryImpl();
    private final Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Handle the splash screen transition.
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getApplicableNetworks();

        swipeRefresh();

        /*Set-Up Applicable network auto-complete Text View Adapter*/
        String[] codes = getResources().getStringArray(R.array.codes);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, codes);
        binding.actvEnterCode.setAdapter(arrayAdapter);

        setEditTextWatcher(binding.actvEnterCode, binding.tilEnterCode);

        binding.btSearch.setOnClickListener(view -> {
            if (!applicableItemList.isEmpty()) {
                Optional<ApplicableItem> applicableItem = findApplicableItem(binding.actvEnterCode.getText().toString());

                if (applicableItem.isPresent()) {
                    /*Navigate to Second Activity*/
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra(Utils.PAYMENT_CODE, gson.toJson(applicableItem.get()));
                    startActivity(intent);
                } else {
                    binding.tilEnterCode.setErrorIconDrawable(null);
                    binding.tilEnterCode.setError(getString(R.string.invalid_code));
                }
            } else {
                Utils.showError(getString(R.string.please_retry), binding.getRoot());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onSuccess(List<ApplicableItem> success) {
        Utils.hideView(binding.progressBar);
        Utils.showView(binding.mainLayout);
        applicableItemList = success;
        ExpressoIdlingResource.getInstance().decrement();
    }

    @Override
    public void onError(BaseException error) {
        Utils.hideView(binding.progressBar);
        Utils.showView(binding.mainLayout);
        Utils.showError("Error Occurred\n" + error.getMessage(), binding.getRoot());
        ExpressoIdlingResource.getInstance().decrement();
    }

    /*Get Applicable Network Response*/
    private void getApplicableNetworks() {
        if (NetworkUtil.isOnline(this)) {
            ExpressoIdlingResource.getInstance().increment();
            Utils.hideView(binding.ivConnection);
            Utils.hideView(binding.tvConnectionLost);
            Utils.hideView(binding.mainLayout);
            Utils.showView(binding.progressBar);
            repository.getApplicableNetworks(this);
        } else {
            Utils.hideView(binding.progressBar);
            Utils.showView(binding.mainLayout);
            Utils.showView(binding.ivConnection);
            Utils.showView(binding.tvConnectionLost);
            Utils.showError("Check network then swipe to refresh", binding.ivConnection);
        }
    }

    /*Swipe to refresh data*/
    public void swipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener(
                () -> {
                    // This method performs the actual data-refresh operation.
                    // The method calls setRefreshing(false) when it's finished.
                    getApplicableNetworks();
                    binding.swipeRefresh.setRefreshing(false);
                }
        );
    }

    /*Method to handle edit-text changes*/
    private void setEditTextWatcher(EditText editText, TextInputLayout textInputLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout.setError(null);
                textInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /*Get Applicable Network Items */
    private Optional<ApplicableItem> findApplicableItem(String code) {
        return applicableItemList.stream().filter(it -> it.getCode().equalsIgnoreCase(code.trim())).findFirst();
    }

}