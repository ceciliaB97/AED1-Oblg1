package trabajarconvectoresenclase;

public class Vectores implements IVectores {

    @Override
    public Retorno mostrarv(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int largo = v.length;
        ret.valorString = " ";
        for (int i = 0; i < largo; i++) {
            ret.valorString += v[i] + " ";
        }
        return ret;
    }

    @Override
    public Retorno maxvec(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //si vector estuvera ordenado, devuelvo el último elemento
        int largo = v.length;
        int maximo = Integer.MIN_VALUE;
        for (int i = 0; i < largo; i++) {
            if (v[i] > maximo) {
                maximo = v[i];
            }
        }
        ret.valorEntero = maximo;
        return ret;
    }

    @Override
    public Retorno maxvecV2(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = v[v.length - 1];
        return ret;
    }

    @Override
    public Retorno minvec(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //si vector estuvera ordenado, devuelvo el primer elemento
        int largo = v.length;
        int minimo = Integer.MAX_VALUE;
        for (int i = 0; i < largo; i++) {
            if (v[i] < minimo) {
                minimo = v[i];
            }
        }
        ret.valorEntero = minimo;
        return ret;
    }

    @Override
    public Retorno minvecV2(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = v[0];
        return ret;
    }

    @Override
    public Retorno maxvec(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //si vector estuvera ordenado, devuelvo el último elemento
        int largo = hasta;
        int maximo = Integer.MIN_VALUE;
        for (int i = desde; i <= largo; i++) {
            if (v[i] > maximo) {
                maximo = v[i];
            }
        }
        ret.valorEntero = maximo;
        return ret;
    }

    @Override
    public Retorno maxvecV2(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = v[hasta];
        return ret;
    }

    @Override
    public Retorno minvec(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //si vector estuvera ordenado, devuelvo el primer elemento
        int largo = hasta;
        int minimo = Integer.MAX_VALUE;
        for (int i = desde; i <= largo; i++) {
            if (v[i] < minimo) {
                minimo = v[i];
            }
        }
        ret.valorEntero = minimo;
        return ret;
    }

    @Override
    public Retorno minvecV2(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = v[desde];
        return ret;
    }

    @Override
    public Retorno posmaxvec(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //si vector estuvera ordenado, devuelvo hasta
        int largo = hasta;
        int maximo = Integer.MIN_VALUE;
        int posicion = -1;
        for (int i = desde; i <= largo; i++) {
            if (v[i] > maximo) {
                maximo = v[i];
                posicion = i;
            }
        }
        ret.valorEntero = posicion;
        return ret;
    }

    @Override
    public Retorno posminvec(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //si vector estuvera ordenado, devuelvo desde
        int largo = hasta;
        int minimo = Integer.MAX_VALUE;
        int posicion = -1;
        for (int i = desde; i <= largo; i++) {
            if (v[i] < minimo) {
                minimo = v[i];
                posicion = i;
            }
        }
        ret.valorEntero = posicion;
        return ret;
    }

    @Override
    public Retorno posminvecV2(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = desde;
        return ret;
    }

    @Override
    public Retorno posmaxvecV2(int[] v, int desde, int hasta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = hasta;
        return ret;
    }

    @Override
    public Retorno buscarvec(int[] v, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int largo = v.length;
        ret.valorbooleano = false;
        //encontrado == false ES LO MISMO QUE !encontrado
        for (int i = 0; i < largo && !ret.valorbooleano; i++) {
            if (v[i] == elemento) {
                ret.valorbooleano = true;
            }
        }
        return ret;
    }

    @Override
    public Retorno buscarvecV2(int[] v, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int largo = v.length;
        ret.valorbooleano = false;
        int i = 0;
        //encontrado == false ES LO MISMO QUE !encontrado
        for (i = 0; i < largo && v[i] < elemento; i++) {

        }

        if (v[i] == elemento) {
            ret.valorbooleano = true;
        }
        return ret;
    }

    @Override
    public Retorno buscarporpuntomedio(int[] v, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int desde = 0;
        int hasta = v.length - 1;
        int puntoMedio = (hasta - desde) / 2;
        ret.valorbooleano = false;
        //si elemento es menor al primero y mayor al ultimo elemento
        if (elemento < v[desde] || elemento > v[hasta]) {
            return ret;
        }
        //si elemento es igual al primero o al ultimo elemento del vector salgo
        if (elemento == v[desde] || elemento == v[hasta]) {
            ret.valorbooleano = true;
            return ret;
        }

        while (desde < hasta) {
            puntoMedio = desde + (hasta - desde) / 2;
            //si elemento es igual al punto medio
            if (v[puntoMedio] == elemento) {
                ret.valorbooleano = true;
                return ret;
            }
            //si es menor acomodo el hasta
            if (elemento < v[puntoMedio]){
                hasta = puntoMedio;
                for(int i = desde; i < hasta && !ret.valorbooleano; i++){
                    if(v[i] == elemento){
                        ret.valorbooleano = true;
                    }
                }
            } else {
                //si es mayor acomodo el desde
                desde = puntoMedio;
                for(int i = desde; i < hasta && !ret.valorbooleano; i++){
                    if(v[i] == elemento){
                        ret.valorbooleano = true;
                    }
                }
            }
            
            return ret;
        }

        return ret;
    }

    @Override
    public Retorno buscarenpos(int[] v, int desde, int hasta, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //hay una bandera, si lo encuentra sale
        ret.valorbooleano = false;
        for (int i = desde; i <= hasta && !ret.valorbooleano; i++) {
            if (v[i] == elemento) {
                ret.valorbooleano = true;
            }
        }
        return ret;
    }

    @Override
    public Retorno buscarenposV2(int[] v, int desde, int hasta, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //hay una bandera, si lo encuentra sale
        ret.valorbooleano = false;
        int i = 0;
        for (i = desde; i <= hasta && v[i] < elemento; i++) {
            //si no lo encuetra sale, si v[i] es mayor a elemento sale
        }

        if (v[i] == elemento) {
            ret.valorbooleano = true;
        }
        return ret;
    }

    @Override
    public Retorno poselemento(int[] v, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int largo = v.length;
        int posicion = -1;
        for (int i = 0; i < largo; i++) {
            if (v[i] == elemento) {
                posicion = i;
            }
        }
        ret.valorEntero = posicion;
        return ret;
    }

    @Override
    public Retorno poselemento(int[] v, int desde, int hasta, int elemento) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int posicion = -1;
        for (int i = desde; i <= hasta; i++) {
            if (v[i] == elemento) {
                posicion = i;
            }
        }
        ret.valorEntero = posicion;
        return ret;
    }

    @Override
    public Retorno ordenarvec1(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int aux;
        int largo = v.length;
        boolean ordenado = false;
        ret.valorString = "\n";
        for (int j = 0; j < largo && ordenado == false; j++) {
            ordenado = true;
            for (int i = j + 1; i < largo; i++) {
                if (v[j] > v[i]) {
                    ordenado = false;
                    aux = v[j];
                    v[j] = v[i];
                    v[i] = aux;
                }
            }
            ret.valorString += mostrarv(v).valorString + " ";

        }
        //ret.valorString = mostrarv(v).valorString;
        return ret;
    }

    @Override
    public Retorno ordenarvec2(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int aux;
        int largo = v.length;
        boolean ordenado = false;
        ret.valorString = "\n";
        for (int j = 0; j < largo && ordenado == false; j++) {
            ordenado = true;
            for (int i = 0; i < largo - j - 1; i++) {
                if (v[i] > v[i + 1]) {
                    ordenado = false;
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
            ret.valorString += mostrarv(v).valorString + " ";

        }
        return ret;
    }

    @Override
    public Retorno ordenarvec3(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int largo = v.length;
        int i = 0;
        int j = largo - 1;
        int pmin;
        int aux;
        int posmax;
        ret.valorString = "";
        while (i <= j) {
            pmin = buscarposmin(v, i, j);
            aux = v[i];
            v[i] = v[pmin];
            v[pmin] = aux;

            posmax = buscoposmax(v, i, j);
            aux = v[j];
            v[j] = v[posmax];
            v[posmax] = aux;

            i++;
            j--;
        }
        ret.valorString = mostrarv(v).valorString;
        return ret;
    }

    //metodo auxiliar buscarposmin(v,i,j)
    public int buscarposmin(int[] v, int desde, int hasta) {
        int min = Integer.MAX_VALUE;
        int pos = desde;
        for (int i = desde; i <= hasta; i++) {
            if (min > v[i]) {
                min = v[i];
                pos = i;
            }
        }
        return pos;
    }

    //metodo auxiliar buscarposmin(v,i,j)
    public int buscoposmax(int[] v, int desde, int hasta) {
        int max = Integer.MIN_VALUE;
        int pos = desde;
        for (int i = desde; i <= hasta; i++) {
            if (max < v[i]) {
                max = v[i];
                pos = i;
            }
        }
        return pos;
    }

    @Override
    public Retorno promedio(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int promedio = -1;
        int sumatoria = 0;
        int largo = v.length;
        for (int i = 0; i < largo; i++) {
            sumatoria += v[i];
        }
        promedio = sumatoria / largo;
        ret.valorEntero = promedio;
        return ret;
    }

    @Override
    public Retorno unirvectoresordenados(int[] v1, int[] v2) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int largoV1 = v1.length;
        int largoV2 = v2.length;
        String nuevaLista = "";
        if (v1[largoV1 - 1] <= v2[0]) {
            for (int i = 0; i < largoV1; i++) {
                nuevaLista += v1[i] + " ";
            }
            for (int i = 0; i < largoV2; i++) {
                nuevaLista += v2[i] + " ";
            }
        } else {
            for (int i = 0; i < largoV2; i++) {
                nuevaLista += v2[i] + " ";
            }
            for (int i = 0; i < largoV1; i++) {
                nuevaLista += v1[i] + " ";
            }
        }
        ret.valorString = nuevaLista;
        return ret;
    }

    @Override
    public Retorno muestroposimpares(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        String resultado = "";
        int largo = v.length;
        for (int i = 0; i < largo; i++) {
            if (v[i] % 2 != 0) {
                resultado += i + " ";
            }
        }
        ret.valorString = resultado;
        return ret;
    }

    @Override
    public Retorno muestropospares(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        String resultado = "";
        int largo = v.length;
        for (int i = 0; i < largo; i++) {
            if (v[i] % 2 == 0) {
                resultado += i + " ";
            }
        }
        ret.valorString = resultado;
        return ret;
    }

    @Override
    public Retorno muestrocontenidosimpares(int[] v) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        String resultado = "";
        int largo = v.length;
        for (int i = 0; i < largo; i++) {
            if (v[i] % 2 != 0) {
                resultado += v[i] + " ";
            }
        }
        ret.valorString = resultado;
        return ret;
    }

}
