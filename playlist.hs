module Playlist ( Playlist, nuevaP, skipP, backP)
where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show)

-- A partir de una lista de temas crea una nueva Playlist con su indice en cero.
nuevaP :: [ Tema ] -> Playlist
nuevaP = Play 0

-- Dada una Playlist devuelve el tema en la posicion indicada por el indice.
actualP :: Playlist -> Tema
actualP (Play Int temas) = temas !! Int -- hacer test

--Devuelve una Playlist con su indice aumentado en uno.
skipP :: Playlist -> Playlist
skipP (Play i temas) = Play (i + 1) temas

-- Idem anterior pero con el indice decrementado en uno.
backP :: Playlist -> Playlist
backP (Play i temas) = Play (i - 1) temas

-- Dada una Playlist crea una nueva con la lista de temas de la original.
resetP :: Playlist -> Playlist
resetP (Play _ temas) = nuevaP [] --no se si se van a meter los valores en la funcion nuevaP, hacer test