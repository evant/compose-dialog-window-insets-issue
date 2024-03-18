# Compose Dialog WindowInsets issues

This repo reproduce 2 issues with how `Dialog` window insets are handled.

1. The indicator for gesture navigation isn't included in the insets on certain OS versions, so the
Dialog will draw under it. Going to system setting and switching to 3 button nav and back will fix
the issue until the next boot.

Reproduced on: Android emulator API 33

Not reproduced on: Android emulator API 34, pixel 8 API 34

2. It's not possible to get Dialog to draw under system bars. There's a property
`decorFitsSystemWindows = false` which sounds like it should control this but as no effect. The
dialog is always inset within the system bars and `WindowInsets` is always 0. Setting
`enableEdgeToEdge()` on the Activity also has no effect.