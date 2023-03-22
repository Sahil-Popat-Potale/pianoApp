package sahil.popat.pianoApp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.app.AlertDialog;
import androidx.annotation.NonNull;

import android.os.Bundle;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    // here first we need to decalare some variables

    private static final int PERMISSION_CONSTANT = 100;  // first is the permission constant


    private static final int REQUEST_PERMISSION_SETTING = 101; // Request permission settings code

    // Then I am creating a array of the name permissionsRequired
    // And i am filling it with the permissions that i want

    String[] permissionsRequired = new String[]{
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
    };

    /* SharedPreferences*/

    private SharedPreferences permissionStatus;

    // Now the sentToSettings variable can be created later that takes the user to the
    // settings the Screen
    private boolean sentToSettings = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //  Here we need to initialize the screen
        permissionStatus = getSharedPreferences("permissionStatus",MODE_PRIVATE);

        /*Here first we need to check for the self permission whether is pre granted or not*/


        if(ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[1]) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[1])
            ){
                //Show Information about why you need the permission

                /*Then need to give some information to user why the permission are required
                 * By building the AlertDialog
                 * */


                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Need Multiple Permissions");
                builder.setMessage("This app needs Storage and Record Audio Permissions.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
            else if (permissionStatus.getBoolean(permissionsRequired[0],false)) {

                /*Now previously the permissions are not allowed so this else block will execute
                 * when the user deny all the permission also the Grant to permissoin dialog as well
                 *
                 * So, the bellow line of code takes the user to the Settings of the Application
                 * From where user need to give the permission manually by taping on the switch button
                 *
                 * */



                // Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission

                /*
                 *   First need to build the dialog that will be shown in which user can interact
                 *   after that need to specify the listener to the positive button
                 * * */

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Need Multiple Permissions");
                builder.setMessage("This app needs Storage and Record Audio Permissions.");


                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        sentToSettings = true;  // then here sets boolean variable to true

                        /* Then with the use of the Intent or Uri Start Activity for the result
                         *  by startActivityForResult()
                         * */

                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                        Toast.makeText(getBaseContext(), "Go to Permissions, Grant Storage and Record Audio ", Toast.LENGTH_LONG).show();
                    }
                });

                /*
                 * Then need to build the negative button so that the user can cancel that
                 * or at the end we need to close the application by calling finish() method
                 *
                 * */
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            } else {
                //just request the permission by calling the requestPermissions() method
                ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
            }

            SharedPreferences.Editor editor = permissionStatus.edit();
            editor.putBoolean(permissionsRequired[0],true);
            editor.commit();
        }else {
            //You already have the permission, just go ahead.
            proceedAfterPermission();
        }
    }


    /*
     *
     *      At the third number we need to call the onRequestPermissionsResult() method
     *
     * */


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_CONSTANT){  // here matching the requestCode to PERMISSION_CONSTANT
            //check if all permissions are granted
            boolean allgranted = false;         // here setting the variable to false

            for(int i=0;i<grantResults.length;i++){
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                    allgranted = true;
                } else {
                    allgranted = false;
                    break;
                }
            }

            if(allgranted){ //its true means permission granted then call the proceedAfterPermission() Method
                proceedAfterPermission(); // This method will takes the user to the PianoActiviy
            } else if(ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[1])
            ){
//
                /*
                 *  Then again here need to build the AlertDialog to give some information to user
                 * */

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Need Multiple Permissions");
                builder.setMessage("This app needs Storage and Record Audio Permissions.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Then at the end we need to show the dialog
                builder.show();
            } else {
                Toast.makeText(getBaseContext(),"Unable to get Permission",Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(),"You Need to give the permission manually by going into the Settings",Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(),"Now closing the Application",Toast.LENGTH_SHORT).show();

                /*This else part excutes and here we can write some code that
                 *  like we can specify a code to close the application
                 *  by calling the finish() method
                 *
                 * */

            }
        }
    }// end of the onRequestPermissionsResult() method


    /*
     *   The following code can be written at the end of the lecture tutorial
     * */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                //Got Permission
                proceedAfterPermission();
            }
        }
    }


    // This can be used to create a second last lecture of The Course when explaining or demonstrate the
    // concept of RuntimePermissions


    /*
     *  proceedAfterPermission() Method is called when the app gets all the permissions successfully
     * */

    private void proceedAfterPermission() {
        Toast.makeText(getBaseContext(), "We got All Permissions", Toast.LENGTH_LONG).show();

        /*
         *  Here you can perform other action that are required or needed for the application
         *  so I am writing a code to start the another activity or can be a login code or splash screen code
         *  to create more impact of the application
         * */

        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);


    }

//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        if (sentToSettings) {
//            if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
//                //Got Permission
//                proceedAfterPermission();
//            }
//        }
//    }
}