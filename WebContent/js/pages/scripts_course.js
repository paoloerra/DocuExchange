function random(){
												var a=document.getElementById('corso').value;
												console.log(a);
												//primo anno
												if(a == 'Programmazione I') {
													var array=["De Marco Gianluca , Zizza Rosalba", "Nappi Michele", "Tucci Maurizio , Distasi Riccardo"];
												}
												if(a == 'Architettura degli elaboratori') {
													var array=["Alberto Negro", "Anselmo Marcella", "Barbara Masucci"];
												}
												if(a == 'Matematica discreta') {
													var array=["Delizia Costantino", "Vincenzi Giovanni", "Lenzi Giacomo"];
												}
												if(a == 'Analisi Matematica') {
													var array=["Di Gironimo Patrizia", "Iovane Gerardo", "Benedetto Elmo"];
												}
												if(a == 'Programmazione e Strutture Dati') {
													var array=["Fuccella Vittorio", "Tucci Maurizio", "Deufemia Vincenzo"];
												}
												if(a == 'Metodi Matematici per Informatica') {
													var array=["De Felice Clelia", "Zaccagnino Rocco", "Rescigno Adele Anna"];
												}
												//secondo anno
												if(a == 'Sistemi operativi') {
													var array=["Rescigno Adele Anna , Abate Andrea Francesco", "Cattaneo Giuseppe", "Carpentieri Bruno"];
												}
												if(a == 'Programmazione Object Oriented') {
													var array=["Deufemia Vincenzo", "La Torre Salvatore", "Gravino Carmine"];
												}
												if(a == 'Basi di dati') {
													var array=["Sebillo Monica Maria Lucia", "Risi Michele , Tortora Genoveffa", "Polese Giuseppe"];
												}
												if(a == 'Calcolo delle probabilità e statistica matematica'){
													var array=["Di Crescenzo Antonio", "Giorno Virginia", "Martinucci Barbara"];
												}
												if(a == 'Tecnologie Software per il Web') {
													var array=["Risi Michele", "Francese Rita", "Costagliola Gennaro , Fuccella Vittorio"];
												}
												if(a == 'Reti di Calcolatori') {
													var array=["Malandrino Delfina , Zaccagnino Rocco", "Palmieri Francesco"];
												}
												if(a == 'Progettazione Algoritmi') {
													var array=["Vaccaro Ugo", "De Bonis Annalisa", "Anselmo Marcella"];
												}
												//terzo anno
												if(a == 'Ingegneria del software') {
													var array=["Ferrucci Filomena , Gravino Carmine", "De Lucia Andrea"];
												}
												if(a == 'Programmazione distribuita') {
													var array=["Malandrino Delfina", "Scarano Vittorio"];
												}
												if(a == 'Elementi di teoria della computazione') {
													var array=["Gargano Luisa", "De Felice Clelia"];
												}
												if(a == 'Ricerca operativa') {
													var array=["Cerulli Raffaele", "Carrabs Francesco"];
												}
												if(a == 'Calcolo scientifico') {
													var array=["Conte Dajana"];
												}
												if(a == 'Grafica ed Interattivita') {
													var array=["Abate Andrea Francesco"];
												}
												if(a == 'Sicurezza') {
													var array=["De Santis Alfredo"];
												}
												if(a == 'Programmazione avanzata') {
													var array=["De Bonis Annalisa"];
												}
												if(a == 'Interazione uomo macchina') {
													var array=["Vitiello Giuliana"];
												}
												if(a == '') {
													var array=[""];
												}
												//non ho messo gli esami a scelta perchè è inutile 
												var string = "";
												for(i = 0; i <array.length; i++) {
													string = string + "<option>"+array[i]+"</option>";
												}
												document.getElementById('professori').innerHTML = string;
											}