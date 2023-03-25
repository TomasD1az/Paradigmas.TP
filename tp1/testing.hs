module Testing where
    
import Tipos 
import Tema 
import Playlist
import FileSystem
import Reproductor


tema1 :: Tema
tema1 = Tem "test1" [] "dato1"
tema2 = Tem "test2" ["Rock"] "dato2"
tema3 = Tem "test3" [] "dato3"

playlist :: Playlist
playlist = Play 0 [tema1, tema2, tema3]

filesystem :: FileSystem
filesystem = FS [] []
filesystem1 = FS ["Rock","Pop"] []
filesystem2 = FS [] [tema1,tema2]

reproductor :: Reproductor
reproductor = RP filesystem (Play 0 [])
reproductor1 = RP filesystem2 (Play 0 [])
reproductor2 = RP filesystem playlist

testTipos = [insertar 10 [4,3,6,34,1] == [1,3,4,6,10,34]]

testT = [
       nuevoT "test1" "dato1" == tema1,
       nombreT tema1 == "test1",
       datosT tema1 == "dato1",
       agregarT "etiqueta1" tema1 == Tem "test1" ["etiqueta1"] "dato1",
       etiquetasT (agregarT "etiqueta1" tema1) == ["etiqueta1"],
       aplicaT "test1" (agregarT "test1" tema1)
       ]

testP = [
       nuevaP [tema1, tema2, tema3] == playlist,
       actualP playlist == tema1,
       skipP playlist == Play 1 [tema1, tema2, tema3],
       backP (skipP playlist) == Play 0 [tema1, tema2, tema3],
       resetP (skipP playlist) == Play 0 [tema1, tema2, tema3]
       ]

testF = [
       nuevoF == filesystem,
       etiquetasF filesystem1 == ["Rock","Pop"],
       temasF filesystem2 == [tema1,tema2],
       agregarF tema3 filesystem2 == FS [] [tema3,tema1,tema2],
       filtrarF "Rock" filesystem2 == [tema2]
       ]

testR = [
       nuevoR filesystem == reproductor,
       archivosR reproductor == filesystem,
       listaParaR "Rock" reproductor1 == [tema2],
       temasR reproductor1 == [tema1,tema2],
       playR reproductor1 "Rock" == RP filesystem2 (Play 0 [tema2]),
       actualR reproductor2 == tema1,
       avanzarR reproductor2 == RP filesystem (skipP playlist),
       retrocederR reproductor2 == RP filesystem (backP playlist),
       reiniciarR reproductor2 == RP filesystem (resetP playlist)
       ]