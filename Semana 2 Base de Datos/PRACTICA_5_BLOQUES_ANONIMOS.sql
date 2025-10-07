--ejercicios de bloeuqes pl/sql

--1.- Imprimir  en consola tu nombre completo, carrera y estado donde vives
DECLARE
    V_NOMBRE NVARCHAR2(50) := 'JORGE EDUARDO CONTRERAS HERNANDEZ';
    V_CARRERA NVARCHAR2(50) := 'ING. EN SISTEMAS COMPUTACIONALES';
    V_ESTADO NVARCHAR2(50) := 'PUEBLA';
--EJECUCION
BEGIN
    dbms_output.put_line(V_NOMBRE);
    dbms_output.put_line(V_CARRERA);
    dbms_output.put_line(V_ESTADO);
END;
/


--2.- impimir las tablas de multiplicar del 1 al 10 ejemplo 
--tabla del 1     1*1 = 10
DECLARE
    v_i NUMBER; --BASE
    v_j NUMBER; -- MULTIPLICADOR
BEGIN
    FOR v_i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE('Tabla del ' || v_i);
        FOR v_j IN 1..10 LOOP
            DBMS_OUTPUT.PUT_LINE(v_i || ' * ' || v_j || ' = ' || (v_i * v_j));
        END LOOP;
    END LOOP;
END;
/



--3.-Impirmir solo los numeros pares del 1 al 20
DECLARE
LV_VARIABLE NUMBER := 2; --:= ES UNA ASIGNACION
BEGIN
    LOOP
       DBMS_OUTPUT.PUT_LINE(LV_VARIABLE);
       LV_VARIABLE := LV_VARIABLE + 2;
       --EXIT WHEN LV_VARIABLE = 10
        IF LV_VARIABLE = 22
           THEN EXIT;
        END IF;
        END LOOP;
END;
/
--4.- Imprimir la suma acumulada de los primeros 10 numeros 
--ejemplo  suma acumulada hasta 
                                                    --1:1
                                                    --2:3
                                                    --3:6
DECLARE
    v_i NUMBER;       -- NUMERO ACTUAL
    v_suma NUMBER := 0; --ACUMULADOR
BEGIN
    FOR v_i IN 1..10 LOOP
        v_suma := v_suma + v_i;
        DBMS_OUTPUT.PUT_LINE( v_i || ': ' || v_suma);
    END LOOP;
END;
/

                                                    
--5.-Imprime la cuenta regresiva del 10 al 1
DECLARE
LV_VARIABLE NUMBER := 10; --:= ES UNA ASIGNACION
BEGIN
    LOOP
       DBMS_OUTPUT.PUT_LINE(LV_VARIABLE);
       LV_VARIABLE := LV_VARIABLE - 1;
       --EXIT WHEN LV_VARIABLE = 10
        IF LV_VARIABLE = 0
           THEN EXIT;
        END IF;
        END LOOP;
END;
/

--6.-Imprime una secuencia numerica de multiplos de 5 hasta el 50
DECLARE
LV_VARIABLE NUMBER := 5; --:= ES UNA ASIGNACION
BEGIN
    LOOP
       DBMS_OUTPUT.PUT_LINE(LV_VARIABLE);
       LV_VARIABLE := LV_VARIABLE + 5;
       --EXIT WHEN LV_VARIABLE = 50
        IF LV_VARIABLE = 55
           THEN EXIT;
        END IF;
        END LOOP;
END;
/
 
--7.-Mostrar los primeros 15 numeros de la serie Fibonacci(cada numero es la suma de los dos anteriores, comenzando con 0 y 1) F(n) = F(n-1) + F(n-2)
DECLARE
    a NUMBER := 0;
    b NUMBER := 1;
BEGIN
    FOR i IN 1..15 LOOP
        DBMS_OUTPUT.PUT_LINE(a);
        a := a + b;
        b := a - b;
    END LOOP;
END;
/