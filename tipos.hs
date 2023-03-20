module Tipos (Datos, Etiqueta, Nombre, insertar) where

type Datos = String
type Etiqueta = String
type Nombre = String

sortFunction :: Ord a => a -> [a] -> [a]
sortFunction x list = sorted ++ [x] ++ drop (length sorted) list
   where
   sorted= [y | y <- list, y < x ]

insertar :: Ord a => a -> [ a ] -> [ a ]
insertar x list = foldr sortFunction [] (list ++ [x])
