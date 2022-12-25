package app.state

import app.view.control.state.ControlPanelState
import app.view.gameinfo.state.GameInfoPanelState
import app.view.info.state.InfoWindowState
import app.view.toast.state.ToastState

object AppState {

    val game = GameState()
    val infoWindow = InfoWindowState()
    val gameInfoPanelState = GameInfoPanelState()
    val controlPanelState = ControlPanelState()
    val toast = ToastState()
}