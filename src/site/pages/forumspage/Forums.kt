package site.pages.forumspage

import components.*
import components.layout.Grid
import components.layout.grid
import components.layout.navigationlayout.MdlContent
import components.layout.navigationlayout.content
import header
import mdlApp
import site.Color

object Forums : MdlContent {
    fun createPage() {
        val mdlApp = mdlApp {
            navigationLayout(Forums, "layout") {
                header(Color.primary) {
                }
                drawer("drawer") {
                    mainElement.header("drawer-header") {
                        setAttribute("style", " background: url('images/icon.jpg') center / cover; padding: 10px;")
                    }

                    nav("navigation") {
                        link {
                            text = "Pagina principal"
                            materialIcons = "forum"
                            href = "index.html"
                        }
                        link {
                            text = "Ingresar"
                            materialIcons = "account_circle"
                            onClick {
                                dialog {
                                    title = "Ingresar"
                                    buttonSecondary = Dialog.Button()
                                }
                            }
                        }
                        link {
                            text = "Acerca de"
                            materialIcons = "info"
                            onClick {
                                dialog {
                                    title = "Acerca de"
                                    content = "Emmanuel Messulam"
                                    buttonSecondary = Dialog.Button()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override val content = content("Foros") {
        grid {
            createX(Array(50) {
                MainPageCard("Tema",
                        """
                        Aca va una corta explicacion sobre
                        la cosa que se va a hablar pero necesito
                        que este texto sea mas largo una linea
                        mas va a bastar creo
                        """)
            })
        }
    }

    private fun Grid.createX(mainPageCards: Array<MainPageCard>) {
        for (mainPageCard in mainPageCards) {
            cellCard(4) {
                size()
                title = mainPageCard.title
                supportingText = mainPageCard.supportingText
            }
        }
    }

    private data class MainPageCard(val title: String, val supportingText: String)

}

