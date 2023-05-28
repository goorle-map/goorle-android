package dev.yjyoon.goorle.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.yjyoon.goorle.R

enum class RegionType(
    @StringRes val stringRes: Int,
    @DrawableRes val imageRes: Int
) {
    Seoul(stringRes = R.string.seoul, imageRes = R.drawable.img_seoul),
    Busan(stringRes = R.string.busan, imageRes = R.drawable.img_busan),
    Daegu(stringRes = R.string.daegu, imageRes = R.drawable.img_daegu),
    Incheon(stringRes = R.string.incheon, imageRes = R.drawable.img_incheon),
    Gwangju(stringRes = R.string.gwangju, imageRes = R.drawable.img_gwangju),
    Daejeon(stringRes = R.string.daejeon, imageRes = R.drawable.img_daejeon),
    Ulsan(stringRes = R.string.ulsan, imageRes = R.drawable.img_ulsan),
    Sejong(stringRes = R.string.sejong, imageRes = R.drawable.img_sejong),
    Gyeonggi(stringRes = R.string.gyeonggi, imageRes = R.drawable.img_gyeonggi),
    Gangwon(stringRes = R.string.gangwon, imageRes = R.drawable.img_gangwon),
    Chungbuk(stringRes = R.string.chungbuk, imageRes = R.drawable.img_chungbuk),
    Chungnam(stringRes = R.string.chungnam, imageRes = R.drawable.img_chungnam),
    Jeonbuk(stringRes = R.string.jeonbuk, imageRes = R.drawable.img_jeonbuk),
    Jeonnam(stringRes = R.string.jeonnam, imageRes = R.drawable.img_jeonnam),
    Gyeongbuk(stringRes = R.string.gyeongbuk, imageRes = R.drawable.img_gyeongbuk),
    Gyeongnam(stringRes = R.string.gyeongnam, imageRes = R.drawable.img_gyeongnam),
    Jeju(stringRes = R.string.jeju, imageRes = R.drawable.img_jeju),
}
