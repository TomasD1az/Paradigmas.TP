module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )
where

import Tipos
data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)