package com.example.android_razrab.navigdrawermikepenz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    Drawer result;
    AccountHeader headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createHeader();

       // Toolbar toolbar = (Toolbar) findViewById ( R.id.toolbar );

        new DrawerBuilder().withActivity(this).build();


       //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("R.string.drawer_item_home").withBadge("1");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("R.string.drawer_item_settings").withBadge("2");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("R.string.drawer_item_settings").withBadge("3");

//create the drawer and remember the `Drawer` result object
         result = new DrawerBuilder()
                .withActivity(this)
                 //.withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(), new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("R.string.drawer_item_settings") ,item3
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D

                        return true;
                    }
                }) .withAccountHeader(headerResult)
                .build();


//set the selection to the item with the identifier 1
      //  result.setSelection(1);
//set the selection to the item with the identifier 2
      //  result.setSelection(item2);
//set the selection and also fire the `onItemClick`-listener
     //   result.setSelection(1, true);


    }





    void createHeader (){


        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.ic_launcher)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.mipmap.ic_launcher_round))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

    }



    void updateBadge(){

        result .updateBadge( 2 ,new StringHolder("222"));


    }

}
