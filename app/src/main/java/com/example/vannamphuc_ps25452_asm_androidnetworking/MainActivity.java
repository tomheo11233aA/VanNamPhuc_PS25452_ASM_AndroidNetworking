package com.example.vannamphuc_ps25452_asm_androidnetworking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vannamphuc_ps25452_asm_androidnetworking.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChonCoSoDaoTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonCoSoDaoTao();
            }
        });

        binding.btnDangNhapVoiGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangNhapVoiGoogle();
            }
        });
    }

    private void chonCoSoDaoTao(){
        final String[] coSoDaoTao = {"FPT Polytechnic HO", "FPT Polytechnic Hà Nội", "FPT Polytechnic Hồ Chí Minh", "FPT Polytechnic Đà Nẵng", "FPT Polytechnic Tây Nguyên", "FPT Polytechnic Cần Thơ", "FPT Polytechnic Bình Dương", "FPT Polytechnic Nha Trang", "FPT Polytechnic Hải Phòng", "FPT Polytechnic Bắc Ninh", "FPT Polytechnic Thanh Hóa", "FPT Polytechnic Hưng Yên", "FPT Polytechnic Long An", "FPT Polytechnic Bình Định", "FPT Polytechnic Quảng Ninh", "FPT Polytechnic Hà Tĩnh", "FPT Polytechnic Quảng Ngãi", "FPT Polytechnic Hà Nam", "FPT Polytechnic Hải Dương", "FPT Polytechnic Thái Nguyên", "FPT Polytechnic Vĩnh Phúc", "FPT Polytechnic Bắc Giang", "FPT Polytechnic Hòa Bình", "FPT Polytechnic Phú Thọ", "FPT Polytechnic Hậu Giang", "FPT Polytechnic Đồng Nai", "FPT Polytechnic Quảng Bình", "FPT Polytechnic Quảng Trị", "FPT Polytechnic Đắk Lắk", "FPT Polytechnic Đắk Nông", "FPT Polytechnic Lâm Đồng", "FPT Polytechnic Bà Rịa - Vũng Tàu", "FPT Polytechnic Sóc Trăng", "FPT Polytechnic Bạc Liêu", "FPT Polytechnic Cà Mau", "FPT Polytechnic Kiên Giang", "FPT Polytechnic An Giang", "FPT Polytechnic Đồng Tháp", "FPT Polytechnic Tiền Giang", "FPT Polytechnic Trà Vinh", "FPT Polytechnic Vĩnh Long", "FPT Polytechnic Cao Bằng", "FPT Polytechnic Yên Bái", "FPT Polytechnic Lào Cai", "FPT Polytechnic Ninh Bình", "FPT Polytechnic Ninh Thuận", "FPT Polytechnic Lạng"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Chọn cơ sở đào tạo");
        builder.setSingleChoiceItems(coSoDaoTao, -1, (dialogInterface, i) -> {
            binding.btnChonCoSoDaoTao.setText(coSoDaoTao[i]);
            dialogInterface.dismiss();
        });
        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void dangNhapVoiGoogle(){
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}