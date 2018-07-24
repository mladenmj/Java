public class tester {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agendaLoader loader = new agendaLoader(agenda);
        loader.load("prenotazioni.txt");

        Clinica sanMatteo = new Clinica("San Matteo", agenda);
        Clinica maugeri = new Clinica("Maugeri", agenda);
        Clinica mondino = new Clinica("Mondino", agenda);
        Piscina s = new Piscina("Campus Aquae");
        Struttura m1 = new Piscina("Don Bosco");
        Struttura s2 = new Palestra("Palestra");
        Struttura s3 = new Palestra("Shadow");
        Struttura m2 = new Palestra("McFit");

        sanMatteo.addStructure(s);
        sanMatteo.addStructure(s2);
        sanMatteo.addStructure(s3);

        maugeri.addStructure(m1);
        maugeri.addStructure(m2);

        Fisioterapista f1 = new Fisioterapista("Fabio", "Rossi");
        Fisioterapista f2 = new Fisioterapista("Mladen", "Rossi");
        Fisioterapista f3 = new Fisioterapista("Max", "Rape");
        Fisioterapista f4 = new Fisioterapista("Dario", "Maestri");
        Fisioterapista f5 = new Fisioterapista("Nobildonno", "Andreini");

        s.addDoctor(f1);
        s2.addDoctor(f2);
        s3.addDoctor(f3);
        m1.addDoctor(f4);
        m2.addDoctor(f5);

        System.out.println(sanMatteo);
        System.out.println(maugeri);
        System.out.println(mondino);
    }
}