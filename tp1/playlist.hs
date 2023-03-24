module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show)

nuevaP :: [ Tema ] -> Playlist
nuevaP = Play 0

actualP :: Playlist -> Tema
actualP (Play int temas) = temas !! int -- hacer test

skipP :: Playlist -> Playlist
skipP (Play i temas) = Play (i + 1) temas -- hacer test

backP :: Playlist -> Playlist
backP (Play i temas) = Play (i - 1) temas -- hacer test

resetP :: Playlist -> Playlist
resetP (Play _ temas) = nuevaP temas -- hacer test

