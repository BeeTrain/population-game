package app.view.map.land

val water = listOf(
    "land/water/watrtl21.png",
    "land/water/watrtl22.png",
    "land/water/watrtl23.png",
    "land/water/watrtl24.png",
    "land/water/watrtl25.png",
    "land/water/watrtl26.png",
    "land/water/watrtl27.png",
    "land/water/watrtl28.png",
    "land/water/watrtl29.png",
    "land/water/watrtl30.png",
    "land/water/watrtl31.png",
    "land/water/watrtl32.png",
    "land/water/watrtl33.png",
)

fun randomWaterPath(): String {
    return water.random()
}