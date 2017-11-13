package com.example.android_razrab.navigdrawermikepenz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Drawer result;
    AccountHeader headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        createHeader();
        createProfile();
        setHeaderBackground();
       // updateBadge();

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

                        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                        startActivity(intent);

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
                //.withHeaderBackground(R.mipmap.ic_launcher)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withIdentifier(1)/*withEmail("mikepenz@gmail.com")*/.withIcon("http://images.clipartpanda.com/profile-clipart-7TaMBzMqc.png")
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();


    }


    void setHeaderBackground(){


        ImageView cover = headerResult.getHeaderBackgroundView(); //get your ImageView

        Picasso.with(this).load("https://www.w3schools.com/howto/img_fjords.jpg").into(cover);


    }



    void createProfile() {
        IProfile profile2 = new   ProfileDrawerItem().withName("userName")  /*.withEmail("emailID")*/.withIcon("https://i.pinimg.com/736x/d0/b1/c1/d0b1c100c871ee188bfb7e6357c61a38--profile-photography-white-photography.jpg").withIdentifier(1);

        headerResult.updateProfile(profile2);


    }




    void updateBadge(){

        result .updateBadge( 2 ,new StringHolder("222"));
        result .updateBadge( 2 ,new StringHolder("33333"));


    }







}
