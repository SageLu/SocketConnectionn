package sage.lu6gmail.com.socketconnection;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToastActivity extends AppCompatActivity {

    @BindView(R.id.button_error_toast)
    Button buttonErrorToast;
    @BindView(R.id.button_success_toast)
    Button buttonSuccessToast;
    @BindView(R.id.button_info_toast)
    Button buttonInfoToast;
    @BindView(R.id.button_warning_toast)
    Button buttonWarningToast;
    @BindView(R.id.button_normal_toast_wo_icon)
    Button buttonNormalToastWoIcon;
    @BindView(R.id.button_normal_toast_w_icon)
    Button buttonNormalToastWIcon;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        ButterKnife.bind(this);
        RxToast.init(this);
    }

    @OnClick({R.id.button_error_toast, R.id.button_success_toast, R.id.button_info_toast, R.id.button_warning_toast, R.id.button_normal_toast_wo_icon, R.id.button_normal_toast_w_icon, R.id.activity_main})
    public void onViewClicked(View view) {
        Log.e("sagedd","vda");
        switch (view.getId()) {
            case R.id.button_error_toast:
                RxToast.error(this, "这是一个提示错误的Toast！", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_success_toast:
                RxToast.success(this, "这是一个提示成功的Toast!", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_info_toast:
                RxToast.info(this, "这是一个提示信息的Toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_warning_toast:
                RxToast.warning(this, "这是一个提示警告的Toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_normal_toast_wo_icon:
                RxToast.normal(this, "这是一个普通的没有ICON的Toast").show();
                break;
            case R.id.button_normal_toast_w_icon:
                Drawable icon = getResources().getDrawable(R.drawable.set);
                RxToast.normal(this, "这是一个普通的包含ICON的Toast", icon).show();
                break;
            case R.id.activity_main:
                break;
        }
    }
}
