package app.model.game

enum class MapSize(val cells: Int) {
    SIZE_S(14),
    SIZE_M(20),
    SIZE_L(30);

    companion object {

        fun default(): MapSize {
            return SIZE_S
        }
    }
}