module FileSystem 
where
import Tipos
import Tema ( Tema, nuevoT )
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq)

instance Show FileSystem
     where show (FS etiquetas temas) = "FileSystem\n" ++ "| Etiquetas: " ++ show etiquetas ++ "\n| Temas:\n" ++ printT temas

printT = foldl (\fold each -> fold ++ show each ++ "\n") ""