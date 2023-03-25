module Testing where
    
import Tipos 
import Tema 
import Playlist
import FileSystem
import Reproductor


tema1 :: Tema
tema1 = Tem "test1" [] "test1"

tema2 = Tem "test2" [] "test2"

tema3 = Tem "test3" [] "test3"

playlist :: Playlist
playlist = Play 0 [tema1, tema2, tema3]

filesystem :: FileSystem
filesystem = FS [] []

reproductor :: Reproductor
reproductor = RP filesystem (Play 0 [])

test = [
       insertar 10 [4,3,6,34,1] == [1,3,4,6,10,34],
       nuevoT "test1" "test1" == tema1,
       nombreT tema1 == "test1",
       etiquetasT (agregarT "test1" tema1) == ["test1"],
       aplicaT "test1" (agregarT "test1" tema1),
       nuevaP [tema1, tema2, tema3] == playlist,
       actualP playlist == tema1,
       skipP playlist == Play 1 [tema1, tema2, tema3],
       backP (skipP playlist) == Play 0 [tema1, tema2, tema3],
       resetP (skipP playlist) == Play 0 [tema1, tema2, tema3]
       ]
