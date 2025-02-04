import SwiftUI
import shared


struct HomeSearch: View {
    var carousselMovie: [Movie]
    
    @State private var currentIndex = 0
    @State private var labelHeight = CGFloat.zero     // << here !!

    var body: some View {
        ScrollView(.horizontal) {
            LazyHStack() {
                ForEach(0..<carousselMovie.count, id: \.self) { index in
                    CarousselImage(
                        carousselImage: carousselMovie[index].backdropPath,
                        movieImage: carousselMovie[index].title
                    )
                }
            }
            .border(Color.blue)
        }
        .border(Color.green)

//        .frame(height: 150)
    }
}

struct CarousselImage: View {
    var carousselImage: String
    var movieImage: String
    
    var body: some View {
        AsyncImage(url: URL(string: carousselImage)) { image in
            if image.image != nil {
                image.image!.resizable()
                    .aspectRatio(contentMode: .fit)
//                    .cornerRadius(10)
////                    .frame(height: 256)
//                    .clipShape(.rect(cornerRadius: 25))
                    .overlay(
                        alignment: .bottomLeading,
                        content: {
                            Text(movieImage)
                                .bold()
                                .foregroundColor(Color.white)
                                .padding()
                        }
                    )
            } else if image.error != nil {
                Text("Image Load Error")
            } else {
                ProgressView()
            }
        }
//        .scaledToFit()
//        .cornerRadius(10)
//        .shadow(radius: 5)
        .frame(height: 200)
//        .padding()
        .clipShape(.rect(cornerRadius: 25))
    }
}
