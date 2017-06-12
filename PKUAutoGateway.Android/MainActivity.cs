using System;
using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;

namespace PKUAutoGateway.Android
{
    [Activity(Label = "PKUAutoGateway.Android", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity
    {
        private int _count = 1;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            this.SetContentView(Resource.Layout.Main);

            // Get our button from the layout resource,
            // and attach an event to it
            Button button = this.FindViewById<Button>(Resource.Id.HelloWorldButton);
            button.Click += (sender, args) => {
                button.Text = $"Button: {this._count++} clicks!";
            };

            // Start our service
            Intent srv = new Intent(Application.Context, typeof(MainService));
            Application.Context.StartService(srv);

            Toast.MakeText(this, "Startup done", ToastLength.Short).Show();
        }
    }
}

