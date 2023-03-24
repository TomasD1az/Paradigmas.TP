module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )
where

import Tipos 
data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Ord)

instance Show Tema
        where show (Tem nombre etiquetas datos) = "Tema: " ++ show nombre ++ " | Etiquetas: " ++ show etiquetas ++ " | Datos: " ++ show datos

nuevoT :: Nombre -> Datos -> Tema
nuevoT nombre = Tem nombre [] 

nombreT :: Tema -> Nombre
nombreT (Tem nombre etiquetas datos) = nombre

datosT :: Tema -> Datos
datosT (Tem nombre etiquetas datos) = datos

etiquetasT :: Tema -> [ Etiqueta ]
etiquetasT (Tem nombre etiquetas datos) = etiquetas

agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre etiquetas datos) = Tem nombre new_etiquetas datos 
   where
    new_etiquetas = insertar etiqueta etiquetas

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta (Tem nombre etiquetas datos) = foldl (\fold each-> (||) (each == etiqueta) fold) False etiquetas


test = [nuevoT "test" "test.mp4" == Tem "test" [] "test.mp4", nombreT (Tem "test" [] "test.mp4") == "hola", datosT (Tem "test" [] "test.mp4") == "test.mp4",
        etiquetasT (Tem "test" ["test123"] "test.mp4") == ["test123"], agregarT "test123" (Tem "test" [] "test.mp4") == Tem "test" ["test123"] "test.mp4", 
        aplicaT "test123" (Tem "test" ["test123"] "test.mp4")
        ]
