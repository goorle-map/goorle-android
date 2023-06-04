package dev.yjyoon.goorle.ui.model

import androidx.annotation.StringRes
import com.naver.maps.geometry.LatLng
import dev.yjyoon.goorle.R

enum class Seoul(
    @StringRes val stringRes: Int,
    val lat: Double,
    val lng: Double,
    val latlng: LatLng = LatLng(lat, lng)
) {
    Gangseo(stringRes = R.string.gangseo, lat = 37.5509574, lng = 126.8495247),
    Yangcheon(stringRes = R.string.yangcheon, lat = 37.51698486, lng = 126.8664924),
    Guro(stringRes = R.string.guro, lat = 37.49542587, lng = 126.8874963),
    Youngdeungpo(stringRes = R.string.youngdeungpo, lat = 37.52635635, lng = 126.8962604),
    Geumcheon(stringRes = R.string.geumcheon, lat = 37.45683394, lng = 126.8954523),
    Gwanak(stringRes = R.string.gwanak, lat = 37.47836117, lng = 126.9515573),
    Dongjak(stringRes = R.string.dongjak, lat = 37.51247483, lng = 126.939306),
    Mapo(stringRes = R.string.mapo, lat = 37.56620337, lng = 126.9019461),
    Seodaemoon(stringRes = R.string.seodaemoon, lat = 37.57915826, lng = 126.9368066),
    Eunpyeong(stringRes = R.string.eunpyeong, lat = 37.60281382, lng = 126.9289274),
    Jongro(stringRes = R.string.jongro, lat = 37.57349703, lng = 126.9789809),
    Yongsan(stringRes = R.string.yongsan, lat = 37.53241302, lng = 126.9905552),
    Junggu(stringRes = R.string.junggu, lat = 37.56387265, lng = 126.9979445),
    Gangbuk(stringRes = R.string.gangbuk, lat = 37.63974412, lng = 127.025529),
    Seongbuk(stringRes = R.string.seongbuk, lat = 37.5893444, lng = 127.0166803),
    Dobong(stringRes = R.string.dobong, lat = 37.66868421, lng = 127.0472014),
    Nowon(stringRes = R.string.nowon, lat = 37.65435455, lng = 127.0564259),
    Jungrang(stringRes = R.string.jungrang, lat = 37.60653604, lng = 127.0928112),
    Dongdaemoon(stringRes = R.string.dongdaemoon, lat = 37.57440763, lng = 127.0397384),
    Seongdong(stringRes = R.string.seongdong, lat = 37.56341639, lng = 127.0369256),
    Gwangjin(stringRes = R.string.gwangjin, lat = 37.5385439, lng = 127.0823761),
    Gangdong(stringRes = R.string.gangdong, lat = 37.53018252, lng = 127.1237834),
    Songpa(stringRes = R.string.songpa, lat = 37.51457652, lng = 127.1059086),
    Gangnam(stringRes = R.string.gangnam, lat = 37.51732833, lng = 127.0473638),
    Seocho(stringRes = R.string.seocho, lat = 37.4835816, lng = 127.0327255)
}
