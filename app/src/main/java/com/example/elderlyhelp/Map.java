package com.example.elderlyhelp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.location.Location;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.TextView;

import com.amap.api.maps.*;
import com.amap.api.maps.model.*;
import com.amap.api.location.*;
import com.amap.api.location.AMapLocationClientOption.*;

public class Map extends AppCompatActivity {

    private AMapLocation aMapLocation;
    private MapView mapView;
    private AMap aMap;

    private double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Toolbar mToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //显示地图
        mapView = (MapView)findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图，此方法必须重写
        mapView.onCreate(savedInstanceState);
        //获取地图对象AMap
        aMap = mapView.getMap();

        //changeInitLoc();
        //改变地图默认位置
        LatLng centerPoint = new LatLng(42.02,121.65);
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerPoint,11));

        //initLoc();
    }

    /*public void changeInitLoc(){

        //初始化定位
        AMapLocationClient locationClient = new AMapLocationClient(getApplicationContext());
        //设置定位模式及参数
        AMapLocationClientOption locationClientOption = new AMapLocationClientOption();
        //设置高精度定位模式
        locationClientOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms
        locationClientOption.setInterval(1000);
        //给定位客户端对象设置定位参数
        locationClient.setLocationOption(locationClientOption);
        //启动定位
        locationClient.startLocation();

        //实现监听器，获取定位结果
        AMapLocationListener mapLocationListener = new AMapLocationListener(){
            @Override
            public void onLocationChanged(AMapLocation aMapLocation){
                if(aMapLocation != null){
                    //定位成功时
                    if(aMapLocation.getErrorCode() == 0){
                        latitude = aMapLocation.getLatitude();
                        longitude = aMapLocation.getLongitude();
                    }
                }
            }
        };

        //改变地图默认位置
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,longitude),11));
    }*/
    //进行定位
    /*public void initLoc(){

        //显示定位小蓝点
        MyLocationStyle myLocationStyle = new MyLocationStyle();//默认连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）
        //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒
        myLocationStyle.interval(2000);
        //设置定位蓝点的Style
        aMap.setMyLocationStyle(myLocationStyle);
        //设置定位按钮 并且可以点击
        UiSettings uiSettings = aMap.getUiSettings();
        //显示默认的定位按钮
        uiSettings.setMyLocationButtonEnabled(true);
        //显示默认的缩放按钮
        uiSettings.setZoomControlsEnabled(true);
        //是否显示定位层并且可以触发定位,默认是false
        aMap.setMyLocationEnabled(true);
        //设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息
        myLocationStyle.showMyLocation(true);

    }*/

    //返回上一界面
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mapView.onSaveInstanceState(outState);
    }

}
