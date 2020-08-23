package com.ihfazh.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Hero> list = new ArrayList<>();
    private String title = "List view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_heroes);
        rv.setHasFixedSize(true);

        list.addAll(HeroesData.getHeroesData());
        showRecyclerList();

        setActionBarTitle(title);


    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }

    }

    private void showRecyclerList() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rv.setAdapter(listHeroAdapter);
    }

    private void showRecyclerGrid(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rv.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCard(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(list);
        rv.setAdapter(cardViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_card:
                title = "Card View";
                showRecyclerCard();
                break;
            case R.id.action_list:
                title = "List View";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Grid View";
                showRecyclerGrid();
                break;
        }

        setActionBarTitle(title);
    }
}