module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, temasR, playR, actualR, avanzarR, retrocederR,
reiniciarR )
where
import Tipos
import Tema
import Playlist
import FileSystem
data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

