package sage.lu6gmail.com.socketconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btntodialog)
    Button btntodialog;
    @BindView(R.id.btntowindow)
    Button btntowindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxToast.init(this);
        ButterKnife.bind(this);
    }

//    public void dialog(View view) {
//        Intent intent = new Intent(this, ToastActivity.class);
//        startActivity(intent);
//
////        RxToast.success(this, "这是一个提示成功的Toast!", Toast.LENGTH_SHORT, true).show();
////        new AlertDialog.Builder(this,R.style.dialog)
////                    .setTitle("标题")
//////                    .setView()
////                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialog, int which) {
////
////                        }
////                    })
////                    .setNegativeButton("取消", null)
////                    .setCancelable(false)
////                    .show();
//
//    }

    @OnClick({R.id.btntodialog, R.id.btntowindow})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btntodialog:
                intent = new Intent(this, ToastActivity.class);
                startActivity(intent);
                break;
            case R.id.btntowindow:
                intent = new Intent(this, WindowActivity.class);
                startActivity(intent);
                break;
        }
    }
}
