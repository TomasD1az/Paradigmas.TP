module Testing where

import Tipos ( insertar)
import Tema ( nuevoT, Tema)

testing :: Eq a => a -> a -> String
testing x y = if x == y then "Ok" else "error"

test = [testing (insertar 5 [2,6,3,9]) [2,3,5,6,9], testing (nuevoT "hola" "hola.mp4") (Tem "hola" [] "hola.mp4")]

---tema :: Tema
---tema = Tem "hola" [] "chau.mp4"