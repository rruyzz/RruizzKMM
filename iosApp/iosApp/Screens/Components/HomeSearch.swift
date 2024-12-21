import SwiftUI
import shared


struct HomeSearch: View {
    var carousselMovie: [Movie]
    
    @State private var currentIndex = 0
    
    var body: some View {
        ScrollView(.horizontal) {
            HStack(spacing: 25) {
                ForEach(0..<carousselMovie.count, id: \.self) { index in
                    ZStack(alignment: .bottomLeading) {
                        AsyncImage(url: URL(string: carousselMovie.first?.backdropPath ?? "")) { phase in
                            if phase.image != nil {
                                phase.image!.resizable().aspectRatio(contentMode: .fit)
                            } else if phase.error != nil {
                                Text("Image Load Error")
                            } else {
                                ProgressView()
                            }
                        }
                    }
                }
            }
        }
    }
}
