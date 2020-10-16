package abu.notification;  
import android.app.NotificationManager;  
import android.content.Context;  
import android.content.res.Resources;  
import android.graphics.BitmapFactory;  
import android.support.v4.app.NotificationCompat;  
import android.support.v7.app.AppCompatActivity;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.RelativeLayout;  
import android.graphics.Bitmap;  
public class MainActivity extends AppCompatActivity {  
    private Context mContext;  
    private Resources mResources;  
    private RelativeLayout mRelativeLayout;  
    private Button mButton;  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        mContext = getApplicationContext();  
        mResources = getResources();  
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);  
        mButton = (Button) findViewById(R.id.btn);  
        mButton.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View view) {  
                NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);  
                builder.setSmallIcon(R.drawable.notification_small_icon);  
                Bitmap bitmap = BitmapFactory.decodeResource(mResources, R.drawable.notification_large_icon);  
                builder.setLargeIcon(bitmap);  
                builder.setContentTitle("Notification Title");  
                builder.setContentText("Hello! Notification service.");  
                int notificationId = 001;  
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);  
                manager.notify(notificationId, builder.build());  
            }  
        });  
    }  
}  