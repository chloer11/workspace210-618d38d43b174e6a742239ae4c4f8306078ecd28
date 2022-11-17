package assn05;

import javax.lang.model.element.PackageElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MinBinHeapER() {
        _heap = new ArrayList<>();
    }
       //_heap = new ArrayList<>();
       //for(int i = 0; i < initialEntries.length; i++) {
           //enqueue(initialEntries[i].getValue(), initialEntries[i].getPriority());
    //}
    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MinBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();
        for(int i = 0; i < initialEntries.length; i++) {
            enqueue(initialEntries[i].getValue(), initialEntries[i].getPriority());
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        // if (_heap.size() == initialEntries.length) ;
        Prioritized <V,P> patient = new Patient<>(value, priority);
        _heap.add(patient);
        bubbleUp(_heap.size() - 1);

        //Prioritized<V, P> pE = new Prioritized<>(value, priority);
        //System.out.println("Enqueuing: "+value+", "+priority);
        //_heap.add(size(), pE);
        //int i = _heap.size();
        //i++;
        //return(bubbleUp(_heap.size() - 1));
    }
    void bubbleUp(int index) {
        if (index == 0) {
            return;
        } else {
            Prioritized<V, P> child = _heap.get(index);
            Prioritized<V, P> parent = _heap.get((index - 1) / 2);
            if (child.getPriority().compareTo(parent.getPriority()) < 0) {
                _heap.set((index - 1) / 2, child);
                _heap.set(index, parent);
                bubbleUp((index - 1) / 2);
            } else {
                return;
            }
        }
    }

    // TODO: enqueue
    public void enqueue(V value) {
        Patient <V, P> patient1 = new Patient<>(value);
        enqueue(value, patient1.getPriority());
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if (_heap.size() == 0) {
            return null;
        } else if (_heap.size() == 1) {
            //int i = _heap.size();
            //i--;
            //return (V) _heap.get(0);
            Prioritized<V, P> temp = _heap.get(0);
            _heap.remove(0);
            return temp.getValue();
        } else {
            Prioritized<V, P> retValue = _heap.get(0);
            _heap.set(0, _heap.get(_heap.size() - 1));   // move last element to the top
            _heap.remove(_heap.size() - 1);
            //int i = _heap.size();
            //i--;
            bubbleDown(0);
            return retValue.getValue();
        }

    }
    void bubbleDown(int index) {
        Prioritized<V, P> parent = _heap.get(index);
        //if (index == 0) {
            //return;
        //PElement<T> parent = _maxHeap.get(index);
        if (!hasLeftChild(index) && !hasRightChild(index)) {
            return;     // is a leaf
        }
        else if (!hasRightChild(index)) {    // only has left child
            Prioritized<V, P> leftChild = _heap.get(leftChild(index));
            if (leftChild.getPriority().compareTo(parent.getPriority()) < 0) {
                _heap.set(index, leftChild);             // interchange
                _heap.set(leftChild(index), parent);
                bubbleDown(leftChild(index)); // recurse on leftChild
            }
            else {return;}  // done
        }
        else {      // has 2 children
            Prioritized<V, P> leftChild = _heap.get(leftChild(index));
            Prioritized<V, P> rightChild = _heap.get(rightChild(index));
            if ((leftChild.getPriority().compareTo(parent.getPriority()) < 0) || (rightChild.getPriority().compareTo(parent.getPriority()) < 0)) {
                if (leftChild.getPriority().compareTo(rightChild.getPriority()) < 0) {
                    _heap.set(index, leftChild);             // interchange parent & leftChild
                    _heap.set(leftChild(index), parent);
                    bubbleDown(leftChild(index));
                }        // recurse on leftChild
                else {
                    _heap.set(index, rightChild);             // interchange parent & rightChild
                    _heap.set(rightChild(index), parent);
                    bubbleDown(rightChild(index));            // recurse on rightChild
                }
            }
           else {return;}  // done
        }
    }

    // TODO: getMin
    @Override
    public V getMin() {
        if (_heap.size() == 0) {
            return null;
        }
        else {
            Prioritized<V, P> retValue = _heap.get(0);
            return retValue.getValue();
        }
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }
    static int leftChild(int index) {
        return (2 * index + 1);
    }
    static int rightChild(int index) {
        return (2 * index + 2);
    }
    boolean hasLeftChild(int index) {
        if (leftChild(index) >= 0 && leftChild(index) < _heap.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
    boolean hasRightChild(int index) {
        if (rightChild(index) >= 0 && rightChild(index) < _heap.size() - 1) {
            return true;
        }
        else {
            return false;
        }
    }
}

//RIP