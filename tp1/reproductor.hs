module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR)
where

import Tipos
import Tema
import Playlist
import FileSystem 

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

nuevoR :: FileSystem -> Reproductor
nuevoR filesys = RP filesys (nuevaP [])

archivosR :: Reproductor -> FileSystem
archivosR (RP filesys playlist) = filesys 

listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP filesys playlist) = filtrarF etiqueta filesys






