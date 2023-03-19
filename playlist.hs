module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show)






