package com.acampdev.busstop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbarID);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerLayoutID);
        navigationView=findViewById(R.id.navigationID);
        txtEmail=findViewById(R.id.userEmailID);
        if(savedInstanceState!=null){
            String correo = savedInstanceState.getString("KEY");
            txtEmail.setText(correo);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.isCheckable()) menuItem.setCheckable(false);
                else menuItem.setCheckable(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.menuLineC:
                        setFragment(0);
                        break;
                    case R.id.menuLineH:
                        setFragment(1);
                        break;
                    case R.id.menuLineM:
                        setFragment(2);
                        break;
                    case R.id.logOutID:
                        setFragment(3);
                        break;
                    default:
                }
                return false;
            }
        });
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setFragment(0);

    }

    public void setFragment(int pos){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (pos){
            case 0:
                LineaCalifornia lineaCalifornia=new LineaCalifornia();
                transaction.replace(R.id.fragmentID,lineaCalifornia);
                transaction.commit();
                break;
            case 1:
                LineaHuanchaco lineaHuanchaco=new LineaHuanchaco();
                transaction.replace(R.id.fragmentID,lineaHuanchaco);
                transaction.commit();
                break;
            case 2:
                LineaMilagro lineaMilagro=new LineaMilagro();
                transaction.replace(R.id.fragmentID,lineaMilagro);
                transaction.commit();
                break;
            case 3:
                Salir salir= new Salir();
                transaction.replace(R.id.fragmentID,salir);
                transaction.commit();
                break;
            default:
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        //txtEmail.setText(data.getStringExtra("KEY"));
    }

}
