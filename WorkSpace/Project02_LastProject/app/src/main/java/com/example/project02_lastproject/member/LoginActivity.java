package com.example.project02_lastproject.member;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_lastproject.MainActivity;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.common.CommonVar;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.example.project02_lastproject.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
//member/login?id=dev&password=dev
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NaverIdLoginSDK.INSTANCE.initialize(this, "zn9VSERm_7CeAZalcIMZ", "BQnSbDaI38", getString(R.string.app_name));
        naverLogin();

        KakaoSdk.init(this, "757b2342b06661cb93cc9854fc5759ff");
        UserApiClient.getInstance().unlink(new Function1<Throwable, Unit>() {
            @Override
            public Unit invoke(Throwable throwable) {
                return null;
            }
        });

        binding.btnLogin.setOnClickListener(v -> {
            login();
        });

        Log.d("키해시", "login: "+getKeyHash(this));

        binding.imgvKakaologin.setOnClickListener(v -> {
            kakaoLogin(this);
        });

    }

    public void login(){
        if(binding.edtId.getText().toString().length() < 1
                || binding.edtPw.getText().toString().length() < 1){
            Toast.makeText(this, "아이디 또는 패스워드를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }
        CommonConn conn = new CommonConn(this, "member/login");
        conn.addParamMap("id", binding.edtId.getText().toString());
        conn.addParamMap("password", binding.edtPw.getText().toString());
        conn.onExcute((isResult, data) -> {
            if(isResult){
                CommonVar.logininfo  = new Gson().fromJson(data, MemberVO.class);
                if(CommonVar.logininfo ==null){
                    Toast.makeText(this, "아이디 또는 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                }else {
//                    CommonVar.logininfo = vo;
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    public void kakaoLogin(Context context){
        KakaoSdk.init(this, "757b2342b06661cb93cc9854fc5759ff");
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인(웹뷰)
        // Kotlin은 경우에 따라서 생성자 대신에 메소드로 객체를 return받음. UserApiClient name = new ... x -> UserApiClient.{static UserApiClient.method}

        Function2<OAuthToken, Throwable, Unit> callback = (token, error) -> {
            if(error != null){
                Log.e("카카오 로그인 에러", "invoke: "+error.getMessage());
            }else {
                Log.d("카카오 로그인 성공", "invoke: "+token.toString());
                getKakaoProfile();
            }
            return null;
        };

        if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(context)){
            Log.d("카카오", "isKakaoTalkLoginAvailable: true");
            UserApiClient.getInstance().loginWithKakaoTalk(context, callback);
        }else{
            Log.d("카카오", "isKakaoTalkLoginAvailable: false");
            UserApiClient.getInstance().loginWithKakaoAccount(context, callback);
        }
    }

    public void getKakaoProfile(){
        UserApiClient.getInstance().me((user, error) -> {
            if(error == null){
                Log.d("카카오", "getKakaoProfile: "+user.toString());
                Log.d("카카오", "getKakaoProfile: "+user.getKakaoAccount().getEmail());
                Log.d("카카오", "getKakaoProfile: "+user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "getKakaoProfile: "+user.getKakaoAccount().getProfile().getThumbnailImageUrl());
            }
            return null;
        });
    }


    public void naverLogin(){
        binding.buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("네이버", "onSuccess: "+NaverIdLoginSDK.INSTANCE.getAccessToken());
                new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse res) {
                        Log.d("네이버", "onSuccess: "+res.getProfile().getEmail());
                        Log.d("네이버", "onSuccess: "+res.getProfile().getNickname());
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: ");
            }
        });
    }




    public static String getKeyHash(final Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo == null)
                return null;

            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}