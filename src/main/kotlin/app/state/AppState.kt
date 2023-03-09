package app.state

import app.view.buildings.state.BuildingsSelectorState
import app.view.control.state.ControlPanelState
import app.view.gameinfo.state.GameInfoPanelState
import app.view.info.state.InfoWindowState
import app.view.settings.state.SettingsState
import app.view.toast.state.ToastState

object AppState {

    val settings = SettingsState()
    val game = GameState()
    val buildingsSelector = BuildingsSelectorState()
    val infoWindow = InfoWindowState()
    val gameInfoPanelState = GameInfoPanelState()
    val controlPanelState = ControlPanelState()
    val toast = ToastState()
}