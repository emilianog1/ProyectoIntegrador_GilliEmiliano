export class persona{
    id?: number; //el signo es para identificar que es un campo que no es necesario
    nombre: string;
    apellido: string;
    imagen: string;

    constructor(nombre: string, apellido: string, imagen: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
    }
}