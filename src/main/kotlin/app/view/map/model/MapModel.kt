package app.view.map.model

private const val PADDING = 0.2

data class MapModel(
    val height: Int = MapConfig.mapHeight,
    val width: Int = MapConfig.mapWidth,
    val cellSize: Int = MapConfig.cellSize,
    val cells: List<Cell> = prepareCells(width, height)
) {

    val widthPaddings = width * PADDING
    val heightPaddings = height * PADDING
    val viewWidth = width * cellSize + widthPaddings
    val viewHeight = height * cellSize + heightPaddings

    fun getCell(index: Int): Cell? {
        if (index < 0) return null
        if (index > width * height - 1) return null

        return cells[index]
    }
}

private fun prepareCells(width: Int, height: Int): List<Cell> {
    return List(width * height) {
        Cell(it)
    }
}