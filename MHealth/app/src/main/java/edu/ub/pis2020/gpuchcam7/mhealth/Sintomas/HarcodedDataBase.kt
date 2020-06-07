package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class HarcodedDataBase {
    private var listIllness: MutableList<Illness> = mutableListOf()

    constructor(){
        //EJEMPLO
        /*
        val illness_0 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_0.addIllnessCause("")
        //Simpotems
        illness_0.addIllnessSintoma(0) //
        //Remeis
        illness_0.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_0)*/

        //A
        val illness_1 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_1.addIllnessCause("Otitis")
        illness_1.addIllnessCause("Mastoiditis")
        illness_1.addIllnessCause("Sinusitis")
        illness_1.addIllnessCause("TCE")
        illness_1.addIllnessCause("Patologia pleuropulmonar o cardíaca")
        illness_1.addIllnessCause("Streptococcus")
        illness_1.addIllnessCause("Staphylococcus")
        illness_1.addIllnessCause("Nocardia")
        illness_1.addIllnessCause("Enterobacteries")
        illness_1.addIllnessCause("Pseudomones")
        //Simpotems
        illness_1.addIllnessSintoma(36) //Mal de cap
        illness_1.addIllnessSintoma(59) //Febre
        illness_1.addIllnessSintoma(21) //Convulsions
        //Paràlisis (qualsevol)
        illness_1.addIllnessSintoma(82)
        illness_1.addIllnessSintoma(83)
        illness_1.addIllnessSintoma(84)
        illness_1.addIllnessSintoma(85)
        illness_1.addIllnessSintoma(86)
        illness_1.addIllnessSintoma(87)
        //Pèrdua de sensibilitat (qualsevol)
        illness_1.addIllnessSintoma(94)
        illness_1.addIllnessSintoma(95)
        illness_1.addIllnessSintoma(96)
        illness_1.addIllnessSintoma(97)
        illness_1.addIllnessSintoma(98)
        illness_1.addIllnessSintoma(99)
        //Remeis
        illness_1.addIllnessRemedy("Drenatge + cefalosporina de 3a generació + metronidazol")
        illness_1.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_1)

        val illness_2 :Illness = Illness("Abdomen inflat")
        //Causes
        illness_2.addIllnessCause("Cirrosi")
        illness_2.addIllnessCause("Neoplàsies")
        illness_2.addIllnessCause("Yuberculosi")
        //Simpotems
        illness_2.addIllnessSintoma(68) //Inflamació abdominal
        illness_2.addIllnessSintoma(35) // i dolor
        //Remeis
        illness_2.addIllnessRemedy("Restricció hidrosalina")
        illness_2.addIllnessRemedy("Diurètics")
        illness_2.addIllnessRemedy("Furosemida")
        listIllness.add(illness_2)

        val illness_3 :Illness = Illness("Angina de pit")
        //Causes
        illness_3.addIllnessCause("Ateroesclerosis coronària")
        //Simpotems
        illness_3.addIllnessSintoma(47) //Dolor al pit
        illness_3.addIllnessSintoma(39) //Dolor al coll
        illness_3.addIllnessSintoma(41) //Dolor a l’esquena
        illness_3.addIllnessSintoma(33) //Disnea
        illness_3.addIllnessSintoma(73) //Mareig
        illness_3.addIllnessSintoma(89) //Pèrdua de coneixement
        illness_3.addIllnessSintoma(79) //Palidesa
        illness_3.addIllnessSintoma(125) //Suor
        illness_3.addIllnessSintoma(107) //Taquipnea
        //Remeis
        illness_3.addIllnessRemedy("Si és la primera vegada anar al metge")
        illness_3.addIllnessRemedy("Nitrats sublinguals, si no para anar al metge!")
        illness_3.addIllnessRemedy("Betabloquejants")
        illness_3.addIllnessRemedy("Calciantagonistes")
        illness_3.addIllnessRemedy("Nitrats")
        illness_3.addIllnessRemedy("Ivabradina")
        listIllness.add(illness_3)

        //B
        val illness_4 :Illness = Illness("Bronquiectàsies")
        //Causes
        illness_4.addIllnessCause("Infeccions")
        illness_4.addIllnessCause("FIbrosi quística")
        illness_4.addIllnessCause("VIH")
        illness_4.addIllnessCause("Discinèsia ciliar primària")
        illness_4.addIllnessCause("Immunodeficiències")
        illness_4.addIllnessCause("Aspergilosis broncopulmonar alèrgica")
        illness_4.addIllnessCause("Substàncies tòxiques")
        illness_4.addIllnessCause("Dèficit d’alfa-1 antitripsina")
        illness_4.addIllnessCause("Síndrome de William Campbel")
        illness_4.addIllnessCause("Síndrome de Young")
        illness_4.addIllnessCause("Síndrome de les ungles grogues")
        illness_4.addIllnessCause("Síndrome de Mounier-Kuhn")
        illness_4.addIllnessCause("Tumors")
        illness_4.addIllnessCause("Cossos estranys")
        illness_4.addIllnessCause("Altres")
        //Simpotems
        illness_4.addIllnessSintoma(0) //Acropàquies
        illness_4.addIllnessSintoma(134)
        illness_4.addIllnessSintoma(135) //Mocs/sang a la tos
        //Remeis
        illness_4.addIllnessRemedy("Hidratació")
        illness_4.addIllnessRemedy("Fisioteràpia respiratòria")
        listIllness.add(illness_4)

        val illness_5 :Illness = Illness("Bronquiolitis")
        //Causes
        illness_5.addIllnessCause("Virus")
        illness_5.addIllnessCause("Artritis reumatoidea")
        illness_5.addIllnessCause("Sjögren")
        illness_5.addIllnessCause("Lupus")
        illness_5.addIllnessCause("Post trasplant")
        illness_5.addIllnessCause("Inhalació de tòxics")
        illness_5.addIllnessCause("Drogues")
        illness_5.addIllnessCause("Infeccions")
        illness_5.addIllnessCause("Idiopàtica")
        //Simpotems
        illness_5.addIllnessSintoma(133) //Tos
        illness_5.addIllnessSintoma(33) //Disnea
        illness_5.addIllnessSintoma(20) //Cianosi
        //Remeis
        illness_5.addIllnessRemedy("Broncodilatadors")
        illness_5.addIllnessRemedy("Antitusígens")
        listIllness.add(illness_5)

        val illness_6 :Illness = Illness("Brucelosis")
        //Causes
        illness_6.addIllnessCause("Brucella (productes làctics no pasteuritzats)")
        //Simpotems
        illness_6.addIllnessSintoma(120)
        illness_6.addIllnessSintoma(121)
        illness_6.addIllnessSintoma(122) //Sensacions estranyes
        illness_6.addIllnessSintoma(50)
        illness_6.addIllnessSintoma(51)
        illness_6.addIllnessSintoma(52)
        illness_6.addIllnessSintoma(53)
        illness_6.addIllnessSintoma(54) //Dolor articulacions
        illness_6.addIllnessSintoma(36) //Mal de cap
        illness_6.addIllnessSintoma(59) //Febre
        illness_6.addIllnessSintoma(21) //Convulsions
        //Paràlisis (qualsevol)
        illness_6.addIllnessSintoma(82)
        illness_6.addIllnessSintoma(83)
        illness_6.addIllnessSintoma(84)
        illness_6.addIllnessSintoma(85)
        illness_6.addIllnessSintoma(86)
        illness_6.addIllnessSintoma(87)
        //Pèrdua de sensibilitat (qualsevol)
        illness_6.addIllnessSintoma(94)
        illness_6.addIllnessSintoma(95)
        illness_6.addIllnessSintoma(96)
        illness_6.addIllnessSintoma(97)
        illness_6.addIllnessSintoma(98)
        illness_6.addIllnessSintoma(99)
        illness_6.addIllnessSintoma(33) //Disnea
        //Tos
        illness_6.addIllnessSintoma(134)
        illness_6.addIllnessSintoma(135)
        illness_6.addIllnessSintoma(136)
        illness_6.addIllnessSintoma(69) //Cames inflades
        // Arrítmies
        illness_6.addIllnessSintoma(12)
        illness_6.addIllnessSintoma(13)
        illness_6.addIllnessSintoma(1) //Adenopatíes
        //Remeis
        illness_6.addIllnessRemedy("Doxiciclina + gentamicina o rifampicina")
        listIllness.add(illness_6)

        //C
        val illness_7 :Illness = Illness("Càncer de pulmó")
        //Causes
        illness_7.addIllnessCause("Tabac")
        illness_7.addIllnessCause("Polució")
        illness_7.addIllnessCause("Altres ")
        //Simpotems
        illness_7.addIllnessSintoma(47) //Dolor pit
        illness_7.addIllnessSintoma(33) //Disnea
        illness_7.addIllnessSintoma(136) //Tos seca
        illness_7.addIllnessSintoma(135) //Sang al tossir
        //Remeis
        illness_7.addIllnessRemedy("Qx ")
        illness_7.addIllnessRemedy("Qt")
        illness_7.addIllnessRemedy("Rt")
        illness_7.addIllnessRemedy("Immunoteràpia")
        listIllness.add(illness_7)

        val illness_8 :Illness = Illness("Chagas")
        //Causes
        illness_8.addIllnessCause("Trypanosoma cruzi, per chinche")
        //Simpotems
        // Arrítmies
        illness_8.addIllnessSintoma(12)
        illness_8.addIllnessSintoma(13)
        illness_8.addIllnessSintoma(55) //Dolor al menjar
        illness_8.addIllnessSintoma(57) //Estrenyiment
        illness_8.addIllnessSintoma(35) //Dolor abdominal
        //Remeis
        illness_8.addIllnessRemedy("Benznidazol")
        listIllness.add(illness_8)

        val illness_9 :Illness = Illness("Creutzfelt-Jakobs")
        //Causes
        illness_9.addIllnessCause("Prions")
        //Simpotems
        illness_9.addIllnessSintoma(29) //Demència
        illness_9.addIllnessSintoma(6) //Alteracions de la marxa
        illness_9.addIllnessSintoma(132) //Tremolors
        illness_9.addIllnessSintoma(4) //Alteracions de la consciència
        illness_9.addIllnessSintoma(139) //Visió borrosa
        //Remeis
        illness_9.addIllnessRemedy("Teràpia salut mental")
        illness_9.addIllnessRemedy("Fisioteràpia")
        illness_9.addIllnessRemedy("Logopèdia")
        listIllness.add(illness_9)

        //D
        val illness_10 :Illness = Illness("Degeneració combinada subaguda de la mèdula espinal:")
        //Causes
        illness_10.addIllnessCause("Dèficit de vitamina B12")
        //Simpotems
        illness_10.addIllnessSintoma(120)
        illness_10.addIllnessSintoma(121)//Sensacions estranyes braços i cames
        illness_10.addIllnessSintoma(6) //Alteracions de la marxa
        illness_10.addIllnessSintoma(83) //Paràlisi cames
        //Remeis
        illness_10.addIllnessRemedy("Vitamina B12 intramuscular")
        listIllness.add(illness_10)

        val illness_11 :Illness = Illness("Demència de cossos de Lewy")
        //Causes
        illness_11.addIllnessCause("Acumulació protèica al cervell")
        //Simpotems
        illness_11.addIllnessSintoma(29) //Demència
        illness_11.addIllnessSintoma(132) //Tremolor
        illness_11.addIllnessSintoma(110) //Rigidesa
        illness_11.addIllnessSintoma(6) //Alteracions de la marxa
        illness_11.addIllnessSintoma(3) //Alucinacions visuals
        //Remeis
        illness_11.addIllnessRemedy("Quetiapina")
        listIllness.add(illness_11)

        val illness_12 :Illness = Illness("Distròfia miotònica de Steinert")
        //Causes
        illness_12.addIllnessCause("Hereditària")
        //Simpotems
        illness_12.addIllnessSintoma(56) //Espasmes
        illness_12.addIllnessSintoma(23) //Debilitat ma, cara i coll
        illness_12.addIllnessSintoma(139) //Pèrdua de visió
        illness_12.addIllnessSintoma(30) //Deteriorament intelectual
        //Remeis
        illness_12.addIllnessRemedy("Fenitoína")
        illness_12.addIllnessRemedy("Quinina")
        illness_12.addIllnessRemedy("Procainamida")
        listIllness.add(illness_12)

        //E
        val illness_13 :Illness = Illness("Procainamida")
        //Causes
        illness_13.addIllnessCause("Contaminació per virus Ébola")
        //Simpotems
        illness_13.addIllnessSintoma(59) //Febre
        illness_13.addIllnessSintoma(36) //Mal de cap
        illness_13.addIllnessSintoma(55) //Dolor al menjar
        illness_13.addIllnessSintoma(50)
        illness_13.addIllnessSintoma(51)
        illness_13.addIllnessSintoma(52)
        illness_13.addIllnessSintoma(53)
        illness_13.addIllnessSintoma(54) //Dolor articulacions
        illness_13.addIllnessSintoma(35) //Dolor abdominal
        illness_13.addIllnessSintoma(141) //Vòmits
        illness_13.addIllnessSintoma(31) //Diarrea
        illness_13.addIllnessSintoma(131) //Taques vermelles
        illness_13.addIllnessSintoma(18) //Butllofes petites
        illness_13.addIllnessSintoma(116) //Sagnat per la boca
        //Remeis
        illness_13.addIllnessRemedy("Hidratació")
        illness_13.addIllnessRemedy("Antitèrmics")
        illness_13.addIllnessRemedy("Transfusions")
        illness_13.addIllnessRemedy("Ciprofloxacino")
        listIllness.add(illness_13)

        val illness_14 :Illness = Illness("Encefalopatia hepàtica")
        //Causes
        illness_14.addIllnessCause("Insuficiència hepàtica")
        //Simpotems
        illness_14.addIllnessSintoma(123) //Son
        illness_14.addIllnessSintoma(132) //Tremolor
        illness_14.addIllnessSintoma(114) //Sang amb les deposicions
        illness_14.addIllnessSintoma(116) //Sang per la boca
        illness_14.addIllnessSintoma(29) //Demència
        illness_14.addIllnessSintoma(56) //Espasmes
        illness_14.addIllnessSintoma(7) //Alteracions de la parla
        //Remeis
        illness_14.addIllnessRemedy("Rentats de colon")
        illness_14.addIllnessRemedy("Antibiòtic")
        illness_14.addIllnessRemedy("lactulosa")
        listIllness.add(illness_14)

        val illness_15 :Illness = Illness("EPOC (Enfermedad Pulmonar Obstructiva Crónica)")
        //Causes
        illness_15.addIllnessCause("Tabac")
        //Simpotems
        illness_15.addIllnessSintoma(136) //Tos
        illness_15.addIllnessSintoma(134) //Moc al tossir
        illness_15.addIllnessSintoma(33) //Disnea
        //Remeis
        illness_15.addIllnessRemedy("Deixar de fumar")
        illness_15.addIllnessRemedy("Broncodilatadors")
        illness_15.addIllnessRemedy("Teofilines")
        illness_15.addIllnessRemedy("Corticoids")
        illness_15.addIllnessRemedy("Inhalats")
        illness_15.addIllnessRemedy("Macròlids")
        illness_15.addIllnessRemedy("Roflumilast")
        illness_15.addIllnessRemedy("Rehabilitació")
        illness_15.addIllnessRemedy("Oxigenoteràpia")
        illness_15.addIllnessRemedy("Transplantament Pulmonar")
        illness_15.addIllnessRemedy("Qx")
        listIllness.add(illness_15)

        //F
        val illness_16 :Illness = Illness("Fasciolasis")
        //Causes
        illness_16.addIllnessCause("Fasciola hepàtica")
        illness_16.addIllnessCause("Fasciola gigàntica, per menjar berros silvestres\n")
        //Simpotems
        illness_16.addIllnessSintoma(59) //Febre
        illness_16.addIllnessSintoma(35) //Dolor abdominal
        illness_16.addIllnessSintoma(31) //Diarrea
        illness_16.addIllnessSintoma(102) //Picor
        illness_16.addIllnessSintoma(64) //Icterícia
        //Remeis
        illness_16.addIllnessRemedy("Triclabendazol o bithionol")
        illness_16.addIllnessRemedy("Corticoides")
        listIllness.add(illness_16)

        val illness_17 :Illness = Illness("Febre botonosa mediterrània")
        //Causes
        illness_17.addIllnessCause("Rickettsia conorii, per paparra del gos")
        //Simpotems
        illness_17.addIllnessSintoma(130) //Taca negra
        illness_17.addIllnessSintoma(59) //Febre
        //Dolor
        illness_17.addIllnessSintoma(35)
        illness_17.addIllnessSintoma(36)
        illness_17.addIllnessSintoma(37)
        illness_17.addIllnessSintoma(38)
        illness_17.addIllnessSintoma(39)
        illness_17.addIllnessSintoma(40)
        illness_17.addIllnessSintoma(41)
        illness_17.addIllnessSintoma(42)
        illness_17.addIllnessSintoma(43)
        illness_17.addIllnessSintoma(44)
        illness_17.addIllnessSintoma(45)
        illness_17.addIllnessSintoma(46)
        illness_17.addIllnessSintoma(47)
        illness_17.addIllnessSintoma(48)
        illness_17.addIllnessSintoma(18) //Butllofes petites
        //Remeis
        illness_17.addIllnessRemedy("Doxiciclina")
        listIllness.add(illness_17)

        val illness_18 :Illness = Illness("Febre hemorràgica crimea-congo")
        //Causes
        illness_18.addIllnessCause("Nairovirus  per paparra")
        //Simpotems
        illness_18.addIllnessSintoma(59) //Febre
        //Dolor
        illness_18.addIllnessSintoma(35)
        illness_18.addIllnessSintoma(36)
        illness_18.addIllnessSintoma(37)
        illness_18.addIllnessSintoma(38)
        illness_18.addIllnessSintoma(39)
        illness_18.addIllnessSintoma(40)
        illness_18.addIllnessSintoma(41)
        illness_18.addIllnessSintoma(42)
        illness_18.addIllnessSintoma(43)
        illness_18.addIllnessSintoma(44)
        illness_18.addIllnessSintoma(45)
        illness_18.addIllnessSintoma(46)
        illness_18.addIllnessSintoma(47)
        illness_18.addIllnessSintoma(48)
        illness_18.addIllnessSintoma(73) //Mareig
        illness_18.addIllnessSintoma(111) //Rigidesa de nuca
        illness_18.addIllnessSintoma(76) //Nàusees
        illness_18.addIllnessSintoma(141) //Vòmits
        illness_18.addIllnessSintoma(31) //Diarrea
        illness_18.addIllnessSintoma(5) //Canvis de comportament
        //Remeis
        illness_18.addIllnessRemedy("Suport i rivabirina")
        listIllness.add(illness_18)
/*
        //G
        val illness_38 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_38.addIllnessCause("")
        //Simpotems
        illness_38.addIllnessSintoma(0) //
        //Remeis
        illness_38.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_38)

        //H
        val illness_37 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_37.addIllnessCause("")
        //Simpotems
        illness_37.addIllnessSintoma(0) //
        //Remeis
        illness_37.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_37)

        //I
        val illness_36 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_36.addIllnessCause("")
        //Simpotems
        illness_36.addIllnessSintoma(0) //
        //Remeis
        illness_36.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_36)

        //J
        val illness_35 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_35.addIllnessCause("")
        //Simpotems
        illness_35.addIllnessSintoma(0) //
        //Remeis
        illness_35.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_35)

        //K
        val illness_34 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_34.addIllnessCause("")
        //Simpotems
        illness_34.addIllnessSintoma(0) //
        //Remeis
        illness_34.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_34)

        //L
        val illness_3 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_3.addIllnessCause("")
        //Simpotems
        illness_33.addIllnessSintoma(0) //
        //Remeis
        illness_33.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_33)

        //M
        val illness_32 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_32.addIllnessCause("")
        //Simpotems
        illness_32.addIllnessSintoma(0) //
        //Remeis
        illness_32.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_32)

        //N
        val illness_31 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_31.addIllnessCause("")
        //Simpotems
        illness_31.addIllnessSintoma(0) //
        //Remeis
        illness_31.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_31)

        //O
        val illness_30 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_30.addIllnessCause("")
        //Simpotems
        illness_30.addIllnessSintoma(0) //
        //Remeis
        illness_30.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_30)

        //P
        val illness_29 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_29.addIllnessCause("")
        //Simpotems
        illness_29.addIllnessSintoma(0) //
        //Remeis
        illness_29.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_29)

        //R
        val illness_28 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_28.addIllnessCause("")
        //Simpotems
        illness_28.addIllnessSintoma(0) //
        //Remeis
        illness_28.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_28)

        val illness_27 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_27.addIllnessCause("")
        //Simpotems
        illness_27.addIllnessSintoma(0) //
        //Remeis
        illness_27.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_27)

        //S
        val illness_26 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_26.addIllnessCause("")
        //Simpotems
        illness_26.addIllnessSintoma(0) //
        //Remeis
        illness_26.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_26)

        //T
        val illness_25 :Illness = Illness("Abscessos cerebrals")
        //Causes
        illness_25.addIllnessCause("")
        //Simpotems
        illness_25.addIllnessSintoma(0) //
        //Remeis
        illness_25.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_25)
*/

        //U
        val illness_24 :Illness = Illness("Uncinariasis")
        //Causes
        illness_24.addIllnessCause("Ancylostoma duodenale")
        illness_24.addIllnessCause("Necator americanus")
        //Simpotems
        illness_24.addIllnessSintoma(35) //Dolor abdominal
        illness_24.addIllnessSintoma(31) //Diarrea
        //Remeis
        illness_24.addIllnessRemedy("Albendazol")
        illness_24.addIllnessRemedy("Mebendazol ")
        illness_24.addIllnessRemedy("Pamoato de pirantel")
        listIllness.add(illness_24)

        val illness_23 :Illness = Illness("Uretritis / Cervicitis")
        //Causes
        illness_23.addIllnessCause("N.gonorrhoeae")
        illness_23.addIllnessCause("C.trachomatis")
        illness_23.addIllnessCause("Mycoplasma")
        illness_23.addIllnessCause("Ureaplasma")
        //Simpotems
        illness_23.addIllnessSintoma(46) //Dolor al pixar
        illness_23.addIllnessSintoma(118) //Secreció uretral
        //Remeis
        illness_23.addIllnessRemedy("Ceftriaxona + azitromicina")
        illness_23.addIllnessRemedy("Ciprofloxacino")
        illness_23.addIllnessRemedy("Doxiciclina")
        listIllness.add(illness_23)

        //V
        val illness_22 :Illness = Illness("Varicela")
        //Causes
        illness_22.addIllnessCause("Virus varicela zoster")
        //Simpotems
        illness_22.addIllnessSintoma(131) //Taques vermelles
        illness_22.addIllnessSintoma(18) //Butllofes petites
        illness_22.addIllnessSintoma(102) //Picor
        illness_22.addIllnessSintoma(59) //Febre
        illness_22.addIllnessSintoma(72) //Malestar general
        //Remeis
        illness_22.addIllnessRemedy("Ceftazidima o meropenem i vancomicina")
        listIllness.add(illness_22)

        val illness_21 :Illness = Illness("Verola")
        //Causes
        illness_21.addIllnessCause("Veriola major")
        //Simpotems
        illness_21.addIllnessSintoma(59) //Febre alta
        illness_21.addIllnessSintoma(72) //Taques vermelles
        illness_21.addIllnessSintoma(18) //Butllofes petites
        //Remeis
        illness_21.addIllnessRemedy("Cidofovir")
        listIllness.add(illness_21)

        //X
        val illness_20 :Illness = Illness("Xancres")
        //Causes
        illness_20.addIllnessCause("Herpes")
        illness_20.addIllnessCause("Sífilis")
        illness_20.addIllnessCause("H.ducreyi")
        //Simpotems
        illness_20.addIllnessSintoma(18) //Butllofes petites
        illness_20.addIllnessSintoma(137) //Úlcera
        //Remeis
        illness_20.addIllnessRemedy("Herpes: aciclovir")
        illness_20.addIllnessRemedy("H.ducreyi: azitromicina")
        listIllness.add(illness_20)

        //Z
        val illness_19 :Illness = Illness("Zika")
        //Causes
        illness_19.addIllnessCause("Virus zika, per mosquit aedes")
        //Simpotems
        illness_19.addIllnessSintoma(59) //Febre
        illness_19.addIllnessSintoma(36) //Mal de cap
        illness_19.addIllnessSintoma(48) //Dolor ulls
        illness_19.addIllnessSintoma(50)
        illness_19.addIllnessSintoma(51)
        illness_19.addIllnessSintoma(52)
        illness_19.addIllnessSintoma(53)
        illness_19.addIllnessSintoma(54) //Dolor articullacions
        illness_19.addIllnessSintoma(1) //Adenopatíes
        illness_19.addIllnessSintoma(131) //Taques vermelles
        //Remeis
        illness_19.addIllnessRemedy("Simptomàtica")
        listIllness.add(illness_19)

    }

    fun getHardcodedData(): MutableList<Illness>{
        return this.listIllness
    }
}