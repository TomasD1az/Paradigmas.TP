module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, playR, temasR)
where

import Tipos
import Tema
import Playlist
import FileSystem 

data Reproductor = RP FileSystem Playlist deriving (Eq)
instance Show Reproductor
     where show (RP filesystem playlist) = "Reproductor\n" ++ "| Filesystem: " ++ show filesystem ++ "\n| playlist:\n" ++ show playlist

nuevoR :: FileSystem -> Reproductor
nuevoR filesys = RP filesys (nuevaP [])

archivosR :: Reproductor -> FileSystem
archivosR (RP filesys playlist) = filesys 

listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP filesys playlist) = filtrarF etiqueta filesys

temasR :: Reproductor -> [Tema]
temasR (RP filesys playlist) = temasF filesys

playR :: Reproductor -> Etiqueta -> Reproductor
playR (RP filesys _) etiqueta = RP filesys playlist
    where playlist = nuevaP (filtrarF (RP filesys _) etiqueta)

--actualR :: Reproductor -> Tema
-- avanzarR :: Reproductor -> Reproductor
-- retrocederR :: Reproductor -> Reproductor
-- reiniciarR :: Reproductor -> Reproductor