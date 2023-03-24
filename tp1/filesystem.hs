module FileSystem (printT, nuevoF, etiquetasF)
where

import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq)

instance Show FileSystem
     where show (FS etiquetas temas) = "FileSystem\n" ++ "| Etiquetas: " ++ show etiquetas ++ "\n| Temas:\n" ++ printT temas

printT = foldl (\fold each -> fold ++ show each ++ "\n") "" -- esta funcion de donde es?

nuevoF :: FileSystem
nuevoF = FS [] [] -- hacer test

etiquetasF :: FileSystem -> [ Etiqueta ]
etiquetasF (FS etiquetas _ ) = etiquetas -- test

temasF :: FileSystem -> [ Tema ]
temasF (FS _ temas) = temas -- test

-- Agrega el tema y sus etiquetas de ser necesario.
-- agregarF :: Tema -> FileSystem -> FileSystem
-- agregarF tema (FS etiquetas temas) = filesystem

filtrarF :: Etiqueta -> FileSystem -> [ Tema ]
filtrarF etiqueta (FS etiquetas temas) = foldr (\each fold-> if elem (etiqueta etiquetasT each) then each:fold else fold) []

tema1 = nuevoT "cancion1" "caca1"
temazo = agregarT "Rock" tema1

tema2 = nuevoT "cancion2" "caca2"
temazono = agregarT "" tema2

filesys1 = FS [] [temazo, temazono]