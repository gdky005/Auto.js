package com.stardust.auojs.inrt.wq;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ToastUtils;
import com.stardust.auojs.inrt.R;
import com.stardust.auojs.inrt.SettingsActivity;
import com.stardust.auojs.inrt.autojs.AutoJs;
import com.stardust.auojs.inrt.launch.GlobalProjectLauncher;
import com.stardust.autojs.core.console.ConsoleView;

/**
 * 开始写正式的 Demo 项目
 */
public class WQActivity extends AppCompatActivity {

    public static final String EXTRA_LAUNCH_SCRIPT = "launch_script";

    Toolbar toolbar;
    ConsoleView consoleView;
    LinearLayout inputContainer;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wq);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        consoleView = findViewById(R.id.console);
        consoleView.setConsole(AutoJs.Companion.getInstance().getGlobalConsole());

        inputContainer = consoleView.findViewById(R.id.input_container);
        inputContainer.setVisibility(View.GONE);


        if (getIntent().getBooleanExtra(EXTRA_LAUNCH_SCRIPT, false)) {
            GlobalProjectLauncher.INSTANCE.launch(this);
        }

        ToastUtils.showShort("from WQ.");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        return true;
    }

}
