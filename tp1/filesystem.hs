module FileSystem  ( FileSystem (FS), nuevoF, etiquetasF, temasF, agregarF, filtrarF )
where

import Tipos
import Tema 

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq)

instance Show FileSystem
     where show (FS etiquetas temas) = "FileSystem\n" ++ "| Etiquetas: " ++ show etiquetas ++ "\n| Temas:\n" ++ printT temas

printT = foldl (\fold each -> fold ++ show each ++ "\n") "" 

nuevoF :: FileSystem
nuevoF = FS [] [] 

etiquetasF :: FileSystem -> [ Etiqueta ]
etiquetasF (FS etiquetas _ ) = etiquetas 

temasF :: FileSystem -> [ Tema ]
temasF (FS _ temas) = temas 

agregarF :: Tema -> FileSystem -> FileSystem
agregarF tema (FS etiquetas temas) = FS (etiquetas ++ etiquetasT tema) (tema : temas)

filtrarF :: Etiqueta -> FileSystem -> [ Tema ]
filtrarF etiqueta (FS etiquetas temas) = foldr (\each fold-> if etiqueta `elem` etiquetasT each then each:fold else fold) [] temas