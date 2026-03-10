package com.tyron.code;

import android.os.Bundle;
import android.view.KeyEvent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.WindowCompat;


import com.tyron.code.ui.project.ProjectManagerFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
            try {
                startActivity(new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:" + getPackageName())));
            } catch (Exception e) {
                startActivity(new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
            }
        }

        String projectPath = getIntent().getStringExtra("project_path");
        if (projectPath != null) {
            /**
             * uncomment this to show confirmation dialog first
            new AlertDialog.Builder(this)
            .setTitle("Received project_path")
            .setMessage(projectPath)
            .setCancelable(false)
            .setPositiveButton("Open Project", (d, w) -> 
                    getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, com.tyron.code.ui.main.MainFragment.newInstance(projectPath, true))
                    .commit())
            .show();
            **/
            getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, com.tyron.code.ui.main.MainFragment.newInstance(projectPath, true))
            .commit();
            return;
        } 

        new AlertDialog.Builder(this)
        .setTitle("Error")
        .setMessage("Project path not found.")
        .setPositiveButton(android.R.string.ok, null)
        .show();
        

        if (getSupportFragmentManager().findFragmentByTag(ProjectManagerFragment.TAG) == null) {
            getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, new ProjectManagerFragment(), ProjectManagerFragment.TAG)
            .commit();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finishAffinity();
    }

}
