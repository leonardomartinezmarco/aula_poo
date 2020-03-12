import java.util.Random;

public class Personagem extends Partida {

        //ATRIBUTOS

        public static String nome;
        public static String classe;
        public static int defesa;
        public static int critico;
        public static int danoMinimo;
        public static int danoMaximo;
        public static int healthPoints;
        private final int armadura;
        private final int vitalidade;
        private int agilidade;
        private final int inteligencia;
        private final int forca;
        private final int sorte;

    //CONSTRUTOR

        public Personagem ()
        {
            this.nome = "";
            this.classe = "Mago";
            this.vitalidade = 10;
            this.armadura = 10;
            this.forca = 10;
            this.inteligencia = 10;
            this.agilidade = 10;
            this.sorte = 10;
            this.defesa = 10 + this.armadura;
            this.critico = this.sorte / 100;
            this.healthPoints = 100;
            this.danoMinimo = 10;
            this.danoMaximo = 20;
        }

    //SETTERS

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public void setClasse (String classe)
    {
        this.classe = classe;
    }

    public void setDefesa (int defesa)
    {
        this.defesa = defesa;
    }

    public void setCritico (int critico)
    {
        this.critico = critico;
    }

    public void setHealthPoints (int healthPoints)
    {
        this.healthPoints = healthPoints;
    }

    public void setDanoMinimo (int danoMinimo)
    {
        this.danoMinimo = danoMinimo;
    }

    public void setDanoMaximo (int danoMaximo)
    {
        this.danoMaximo = danoMaximo;
    }

    //GETTERS

    public String getNome ()
    {
        return this.nome;
    }

    public String getClasse ()
    {
        return this.classe;
    }

    public int getDefesa ()
    {
        return this.defesa;
    }

    public int getCritico ()
    {
        return this.critico;
    }

    public int getHealthPoints ()
    {
        return this.healthPoints;
    }

    public int getDanoMinimo ()
    {
        return this.danoMinimo;
    }

    public int getDanoMaximo ()
    {
        return this.danoMaximo;
    }

    public void Ataque (Personagem inimigo)
    {
        Random rand = new Random();

        int ataque;

        ataque = rand.nextInt(this.danoMaximo) + this.danoMinimo;
        inimigo.healthPoints = ataque - inimigo.defesa;

    }

    public void recebeDano (Personagem inimigo ,int ataque)
    {
        this.healthPoints = ataque - defesa;

    }

    public int getAgilidade() {
        return 0;
    }
}

