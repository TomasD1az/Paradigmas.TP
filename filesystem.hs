module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)
