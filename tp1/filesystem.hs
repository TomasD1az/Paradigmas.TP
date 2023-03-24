module FileSystem (printT, nuevoF, etiquetasF)
where

import Tipos
import Tema ( Tema, nuevoT )
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

instance Show FileSystem
     where show (FS etiquetas temas) = "FileSystem\n" ++ "| Etiquetas: " ++ show etiquetas ++ "\n| Temas:\n" ++ printT temas

printT = foldl (\fold each -> fold ++ show each ++ "\n") "" -- esta funcion de donde es?

nuevoF :: FileSystem
nuevoF = FS [] [] -- hacer test

etiquetasF :: FileSystem -> [ Etiqueta ]
etiquetasF (FS etiquetas _ ) = etiquetas !! -- no se si esto esta bien, tampoco se que pide