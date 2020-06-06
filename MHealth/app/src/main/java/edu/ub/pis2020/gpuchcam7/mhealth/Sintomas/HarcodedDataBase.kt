package edu.ub.pis2020.gpuchcam7.mhealth.Sintomas

class HarcodedDataBase {
    private lateinit var listIllness: MutableList<Illness>

    constructor(){
        val illness_1 :Illness = Illness("Angina de pit")
        //Causes
        illness_1.addIllnessCause("Ateroesclerosis coronària")
        //Simpotems
        illness_1.addIllnessSintoma(0) //Pit_D
        illness_1.addIllnessSintoma(1) //Coll_D
        illness_1.addIllnessSintoma(2) //Disnea
        illness_1.addIllnessSintoma(3) //Mareig
        illness_1.addIllnessSintoma(4) //Pèrdua de coneixement
        illness_1.addIllnessSintoma(5) //Palidesa
        illness_1.addIllnessSintoma(6) //Suor
        illness_1.addIllnessSintoma(7) //Taquipnea_R
        //illness_1.addIllnessSintoma() // Esquena_D
        //illness_1.addIllnessSintoma() // Braç esquerra_D
        //illness_1.addIllnessSintoma() // Mandibula_D
        //Remeis
        illness_1.addIllnessRemedy("Si és la primera vegada anar al metge")
        illness_1.addIllnessRemedy("Nitrats sublinguals, si no para anar al metge!")
        illness_1.addIllnessRemedy("Betabloquejants, Calciantagonistes, Nitrats, Ivabradina")

        listIllness = mutableListOf(illness_1)
    }

    fun getHardcodedData(): MutableList<Illness>{
        return this.listIllness
    }
}