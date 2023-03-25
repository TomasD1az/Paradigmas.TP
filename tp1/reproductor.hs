module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, playR, temasR)
where

import Tipos
import Tema
import Playlist
import FileSystem 

data Reproductor = RP FileSystem Playlist deriving (Eq)
instance Show Reproductor
     where show (RP filesystem playlist) = "Reproductor\n" ++ "| Filesystem: " ++ show filesystem ++ "\n| Playlist:\n" ++ show playlist

nuevoR :: FileSystem -> Reproductor
nuevoR filesys = RP filesys (nuevaP [])

archivosR :: Reproductor -> FileSystem
archivosR (RP filesys playlist) = filesys 

listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP filesys playlist) = filtrarF etiqueta filesys

temasR :: Reproductor -> [Tema]
temasR (RP filesys playlist) = temasF filesys

playR :: Reproductor -> Etiqueta -> Reproductor
playR reproductor etiqueta = RP (archivosR reproductor) playlist
    where playlist = nuevaP (listaParaR etiqueta reproductor)

actualR :: Reproductor -> Tema
actualR (RP filesys playlist) = actualP playlist

avanzarR :: Reproductor -> Reproductor
avanzarR (RP filesys playlist) = RP filesys (skipP playlist)

retrocederR :: Reproductor -> Reproductor
retrocederR (RP filesys playlist) = RP filesys (backP playlist)

reiniciarR :: Reproductor -> Reproductor
reiniciarR (RP filesys playlist) = RP filesys (resetP playlist)